import axios from "axios";

export const api = axios.create({
    baseURL: "http://localhost:8085/sbnz2023tim3",
    headers: {
        "Content-Type": "application/json"
    },
});

api.interceptors.request.use(
    (config) => {
        let token = null;
        try {
            token = sessionStorage.getItem("user");
        } catch (e) {
        }
        if (token) {
            config.headers["Authorization"] = `Bearer ${token}`;
        }
        return config;
    },
    (error) => Promise.reject(error)
);

