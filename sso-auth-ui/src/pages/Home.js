import React from 'react';
import {Link} from "react-router-dom";

const Home = (props) => {
    return (
        <div>
            <p style={{margin: "0 45%"}}>Home</p>
            {
                props.authenticated ?
                    <b style={{margin: "0 45%"}} onClick={props.logout}>Logout</b> :
                    <b style={{margin: "0 45%"}}><Link to={"/login"}>Login</Link></b>
            }
        </div>
    );
};

export default Home;