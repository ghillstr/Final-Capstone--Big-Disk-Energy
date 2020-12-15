import axios from 'axios';
const http = axios.create({
    baseURL: "http://localhost:8080"
});
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