import { api } from '../helpers';

const basePath = '/api/GestionSillones';

function getAll() {
    return api.get(`${basePath}/equipos`);
}

function show(teamId) {
    return api.get(`${basePath}/?id=${teamId}`)
}

function create(data) {
    return api.post(`${basePath}/`, data);
}

function getByEstado(){
  return api.get(`${basePath}/false`);
}

const teamsService = {
    getAll,
    show,
    create,
  getByEstado,
};

export default teamsService;
