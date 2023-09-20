import React from 'react';
import {Link, NavLink} from "react-router-dom";

const AppHeader = () => {
    return (
        <div>
            <header className="app-header">
                <div className="container">
                    <div className="app-branding">
                        <Link to="/" className="app-title">
                            React Login
                        </Link>
                    </div>
                    <div className="app-options">
                        <nav className="app-nav">
                            {this.props.authenticated ? (
                                <ul>
                                    <li>
                                        <a onClick={this.props.onLogout}>Logout</a>
                                    </li>
                                </ul>
                            ) : (
                                <ul>
                                    <li>
                                        <NavLink to="/login">Login</NavLink>
                                    </li>
                                </ul>
                            )}
                        </nav>
                    </div>
                </div>
            </header>
        </div>
    );
};

export default AppHeader;