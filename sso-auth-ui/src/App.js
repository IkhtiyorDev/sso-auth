import React, {useEffect, useState} from 'react';
import LoadingIndicator from "./component/LoadingIndicator";
import {BrowserRouter, Navigate, Route, Routes} from "react-router-dom";
import Home from "./pages/Home";
import Login from "./pages/Login";
import NotFound from "./pages/NotFound";
import OAuth2RedirectHandler from "./pages/OAuth2RedirectHandler";
import {ACCESS_TOKEN} from "./constants";
import auth from "./service/Auth";
import Profile from "./pages/Profile";

const App = () => {

    const [authenticated, setAuthenticated] = useState(false);
    const [currentUser, setCurrentUser] = useState('');
    const [loading, setLoading] = useState(false);

    const loadCurrentlyLoggedInUser = () => {
        setLoading(true)

        auth.profile().then(response => {
            setCurrentUser(response.data);
            setAuthenticated(true);
            setLoading(false);
        }).catch(error => {
            setLoading(false)
        });
    }

    useEffect(() => {
        loadCurrentlyLoggedInUser()
    }, []);

    const handleLogout = () => {
        localStorage.removeItem(ACCESS_TOKEN);
        setAuthenticated(false)
        setCurrentUser(null)
        alert("You're safely logged out!");
    }


    if (loading) {
        return <LoadingIndicator/>;
    }

    return (
        <BrowserRouter>

            <Routes>
                <Route exact path="/" element={<Home authenticated={authenticated} logout={handleLogout}/>}></Route>
                <Route path="/login" element={<Login logout={handleLogout}/>}></Route>
                <Route path="/oauth2/redirect" element={<OAuth2RedirectHandler/>}></Route>
                <Route path="/profile" element={<Profile currentUser={currentUser} authenticated={authenticated}
                                                         logout={handleLogout}/>}></Route>
                <Route component={NotFound}></Route>
            </Routes>

        </BrowserRouter>
    );
};

export default App;