import axios from 'axios';

export default {

    recordScore(score) {
        return axios.post('/score', score)
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