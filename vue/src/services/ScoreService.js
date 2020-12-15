import axios from 'axios';

export default {

    recordScore() {
        return axios.post('/score')
    },

    list(leagueName) {
        return axios.get(`/leagueScores/${leagueName}`)
    },

    getAllScoresByUsername() {
        return axios.get('/leagueScores')
    }
}