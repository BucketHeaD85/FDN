import {api} from "../helpers";

const basePath = "/api/GestionSalasQuimio";
const baseSillones = "/api/GestionSillones"

const config = {
    headers: {
        accept: 'application/json',
    },
    data: {},
};

function disponibilizar(objeto){
    return api.put(`${baseSillones}/${objeto}`,  config);
}

function getAll(){
    return api.get(`${basePath}/`);
}



const sillonesService = {
    getAll,
    disponibilizar
};

export default sillonesService;
