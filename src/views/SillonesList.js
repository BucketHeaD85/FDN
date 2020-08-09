import React, {Component} from "react";
import sillonesService from "../services/sillones.service";
import Jumbotron from "react-bootstrap/Jumbotron";
import Container from "react-bootstrap/Container";
import Button from "react-bootstrap/Button";
import ToggleButton from "react-bootstrap/ToggleButton"
import Alert from "react-bootstrap/Alert";
import Form from 'react-bootstrap/Form'
import ToggleButtonGroup from "react-bootstrap/ToggleButtonGroup";
import Modal from "react-bootstrap/Modal";
import Navbar from "react-bootstrap/Navbar";

import usuario from "../assets/user.png";
import check from "../assets/check.png";
import {trackPromise} from "react-promise-tracker";
import Nav from "react-bootstrap/Nav";
import NavDropdown from "react-bootstrap/NavDropdown";
import {NavLink} from "react-bootstrap";
import NavigationBar from "./NavigationBar";

class SillonesList extends Component{

    constructor(props) {

        super(props);
        this.state = {
            mostrarVentanaPacientes:false,
            mostrarVentanaLiberacion:false,
            salas:[],
            elegida:0,
            mostrar:false,
            radios:[],
            checked: false,
            valorRadio: -1,
            idLiberado: -1
        }
        this.tarjetaSillon = this.tarjetaSillon.bind(this);
        this.listadoSillones = this.listadoSillones.bind(this);
        this.ventanaPacientes = this.ventanaPacientes.bind(this);
        this.liberarSillon = this.liberarSillon.bind(this);
    }

    componentDidMount() {
        this.cargarSillones()

    }
    cargarNavBar(){
        return(
            <Navbar collapseOnSelect expand="lg" bg="dark" variant="dark">
                <Navbar.Toggle aria-controls="responsive-navbar-bar"/>
                <Navbar.Collapse id="responsive-navbar-nav">
                    <Nav className="mr-auto">
                        <NavDropdown title="Secciones" id="basic-nav-dropdown">
                            <NavDropdown.Item href="#gotem">Sección</NavDropdown.Item>
                            <NavDropdown.Item href="#gotem">Otra sección</NavDropdown.Item>
                        </NavDropdown>
                    </Nav>
                </Navbar.Collapse>

            </Navbar>
        );
    }

    cargarSillones(){
        trackPromise(
            sillonesService.getAll().then((response) => {
                this.setState({
                    salas: response.status === 200 ? response.data : []
                });
                this.state.salas.map((sala,index) => {
                    this.setState({
                        radios: [...this.state.radios,{
                            name: "Radio",
                            valor: index+1
                        }]
                    })
                });
            })
        );
    }
    liberarSillon(){
        sillonesService.disponibilizar(this.state.idLiberado)
        this.cargarSillones()
        this.setState({
            mostrarVentanaLiberacion:false,
            idLiberado:-1
        })

    }

    ventanaPacientes(){
        return(
            <>
                <Modal
                show={this.state.mostrarVentanaPacientes}
                onHide={ () => this.setState({
                    mostrarVentanaPacientes:false
                })}
                backdrop="static"
                keyboard={false}
                >
                    <Modal.Header closeButton>
                        <Modal.Title>Asignar paciente</Modal.Title>
                    </Modal.Header>
                    <Modal.Body>
                        <Form>
                            <Form.Group controlId="asignacion">
                                <Form.Label>Identificador del paciente</Form.Label>
                                <Form.Control type="text" placeholder="RUT o DAU" size="sm"></Form.Control>
                            </Form.Group>
                        </Form>
                    </Modal.Body>
                    <Modal.Footer>
                        <Button variant="info">
                            Ingresar paciente
                        </Button>
                        <Button variant="light" onClick={() => this.setState({
                            mostrarVentanaPacientes:false
                        })}>
                            Cancelar
                        </Button>
                    </Modal.Footer>
                </Modal>

                <Modal
                    show={this.state.mostrarVentanaLiberacion}
                    onHide={ () => this.setState({
                        mostrarVentanaLiberacion:false
                    })}
                    backdrop="static"
                    keyboard={false}
                >
                    <Modal.Header closeButton>
                        <Modal.Title>Liberar sillón</Modal.Title>
                    </Modal.Header>
                    <Modal.Body>
                        <Form>
                            <Form.Group controlId="asignacion">
                                <Form.Label>¿Liberar el sillón seleccionado?</Form.Label>
                            </Form.Group>
                        </Form>
                    </Modal.Body>
                    <Modal.Footer>
                        <Button variant="info" onClick={()=>
                            this.liberarSillon()
                        }>
                            Liberar sillón
                        </Button>
                        <Button variant="light" onClick={() => this.setState({
                            mostrarVentanaLiberacion:false
                        })}>
                            Cancelar
                        </Button>
                    </Modal.Footer>
                </Modal>
            </>
        )
    }

    grupoBotones(){
        return (
            <>
                <ToggleButtonGroup type="radio" name="salas">
                    {this.state.radios.map((radio, idx) => (
                        <ToggleButton
                            key={idx}
                            type="radio"
                            variant="info"
                            value={radio.valor}
                            onChange={(e) => this.setState({
                                valorRadio: e.currentTarget.value
                            })}
                            onClick={ () => this.setState({
                                mostrar: true,
                                elegida: idx+1
                            })}>
                            Ver sala {idx+1}
                        </ToggleButton>
                    ))}
                </ToggleButtonGroup>
            </>
        );
    }

    tarjetaSillon(sillon,idx){
        let variante = "info";
        let imagen = check;
        let variante_outline = "outline-info";
        if(sillon.ocupado === true){
            variante = "danger";
            imagen = usuario;
            variante_outline = "outline-danger";
            return(
                <Alert variant={variante} key={idx} onClose={() => this.setState(
                    {
                        mostrar: false
                    })} >
                    <Alert.Heading>
                        ID sillon: {sillon.id_sillon}
                        <div className="d-flex justify-content-end" key={idx}>
                            <img src={imagen} alt="Imagen usuario"/>
                        </div>
                    </Alert.Heading>
                    <div className="d-flex justify-content-lg-start">
                        <Button variant={variante_outline} onClick={ () => this.setState({
                            mostrarVentanaLiberacion:true,
                            idLiberado:sillon.id_sillon
                        })}>
                            Liberar sillón
                        </Button>
                    </div>
                </Alert>
            );
        }

        return(
            <Alert variant={variante} key={idx} onClose={() => this.setState(
                {
                mostrar: false
            })} >
                <Alert.Heading>
                    ID sillon: {sillon.id_sillon}
                    <div className="d-flex justify-content-end" key={idx}>
                        <img src={imagen} alt="Imagen usuario"/>
                    </div>
                </Alert.Heading>
                <div className="d-flex justify-content-lg-start">
                    <Button variant={variante_outline}
                    onClick={ () => this.setState({
                        mostrarVentanaPacientes:true
                    })}>
                        Asignar paciente
                    </Button>
                </div>
            </Alert>
        );

    }

    listadoSillones(listado){

        return(
            <Container className="p-3" fluid>
                <NavigationBar/>
                <Jumbotron className="pb-1">
                    <h1>Área de Quimioterapia</h1>
                    <h2>Visualización de Sillones</h2>
                    {this.grupoBotones()}
                    <Alert variant="light" className="mt-2" onClose={() => this.setState(
                        {
                            mostrar: false
                        })} dismissible>
                        <Alert.Heading></Alert.Heading>
                            {listado.map((sillon,index) => {
                                return (
                                    this.tarjetaSillon(sillon,index)
                                );
                            })}
                         </Alert>
                </Jumbotron>
                {this.ventanaPacientes()}

            </Container>
        )
    }

    render() {
        const mostrar = this.state.mostrar;
        if(mostrar){
            const salas = this.state.salas;
            return(
                salas.map((sala,index) => {
                    if(sala.id === this.state.elegida){
                        return(
                            this.listadoSillones(sala.sillones)
                        );
                    }
                })
            )
        }
        return(
            <Container className="justify-content-center" fluid>
                <NavigationBar></NavigationBar>
                <Jumbotron className="pb-1 ">
                    <h1>Área de Quimioterapia</h1>
                    <h2>Visualización de Sillones</h2>
                    {this.grupoBotones()}
                </Jumbotron>
            </Container>
        )

    }
}



export default SillonesList;