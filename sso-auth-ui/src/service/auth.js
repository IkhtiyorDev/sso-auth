import http from "../http-common";

const BASE_API = "/api/auth";

class auth {

    profile(v) {
        return http.get(BASE_API + "/profile", v);
    }


}

export default new auth();