import React from 'react';
import {GOOGLE_AUTH_URL} from "../constants";

const Login = () => {
    return (
        <div>
            <a className="btn btn-block social-btn google" href={GOOGLE_AUTH_URL}>
                <p style={{margin:"5% 45%"}}>Log in with Google</p>
            </a>
        </div>
    );
};

export default Login;