
import axios from 'axios';
const LOCALHOST='http://localhost:3003'

export const API_BASE_URL = LOCALHOST

const api = axios.create({
  baseURL: API_BASE_URL,

    mode: 'cors',
    credentials: 'include'
  
});

const token = localStorage.getItem('jwt');
//console.log((token.toString()));

api.defaults.headers.common['Authorization'] = `Bearer ${token}`;

api.defaults.headers.post['Content-Type'] = 'application/json';

export default api;
