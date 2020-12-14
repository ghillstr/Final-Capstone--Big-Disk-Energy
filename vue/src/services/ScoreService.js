import axios from 'axios';

export default {

    recordScore() {
        return axios.post('/score')
    },

    getAllScoresByLeagueName(leagueName) {
        return axios.get(`/leaderboard/${leagueName}`)
    },

    getAllScoresByUsername() {
        return axios.get('/leagueScores')
    }
}