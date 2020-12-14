import axios from 'axios';

export default {

    recordScore() {
        return axios.post('/')
    },

    getAllScoresByLeagueName() {
        return axios.get('/')
    },

    getAllScoresByUsername() {
        return axios.get('/')
    }
}