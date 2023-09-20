import axios from "axios";
import {ACCESS_TOKEN, API_BASE_URL} from "./constants";

export default axios.create({
    baseURL: API_BASE_URL,
    headers: {
        "Content-type": "application/json",
        "Authorization": "Bearer " + localStorage.getItem(ACCESS_TOKEN)
    }
});