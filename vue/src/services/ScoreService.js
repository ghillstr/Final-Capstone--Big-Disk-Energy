import axios from 'axios';

export default {

    recordScore() {
        return axios.post('/score')
    },

    list(leagueName) {
        return axios.get(`/leaderboard/${leagueName}`)
    },

    getUserByLeague(leagueName) {
        return axios.get(`/leagueUsers/${leagueName}`)
    },

    getAllScoresByUsername() {
        return axios.get('/leagueScores')
    }
}