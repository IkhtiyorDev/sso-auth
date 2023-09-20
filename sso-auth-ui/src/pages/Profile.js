import React from 'react';

const Profile = (props) => {

    const currentUser = props.currentUser ? props.currentUser : {};

    return (
        <div style={{margin: "0 45%"}}>
            <p>{currentUser.name}</p>
            <p>{currentUser.email}</p>
            <p><img src={currentUser.imageUrl} alt={currentUser.imageUrl}/></p>
            <p>{currentUser.username}</p>
            <b style={{margin: "0 45%"}} onClick={props.logout}>Logout</b>
        </div>
    );
};

export default Profile;