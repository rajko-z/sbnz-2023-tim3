import React from 'react';
import {Navigate} from 'react-router-dom';
import {userRole} from "../model/auth/roles";

interface PrivateRouteProps {
    isAuthenticated: boolean;
    role: userRole | null;
    allowedRoles: string[];
    redirectPath: string;
    component: React.ComponentType<any>;
}

const PrivateRoute: React.FC<PrivateRouteProps> = ({
                                                       isAuthenticated,
                                                       role,
                                                       allowedRoles,
                                                       redirectPath,
                                                       component: Component
                                                   }) => {
    if (role) {
        //provera da li korisnik ima pristup odredjenoj ruti
        let hasAccess =
            isAuthenticated && allowedRoles.some((allowedRole) => role.toString() === allowedRole.toString());

        let path = redirectPath;

        if (role.toString() === userRole.ROLE_DOKTOR.toString()) {
            path = '/doktor';
        } else if (role.toString() === userRole.ROLE_PACIJENT.toString()) {
            path = '/pacijent';
        }

        return (
            hasAccess ? (
                <Component/>
            ) : (
                <Navigate to={path}/>
            )

        );
    }

    return (
        <Navigate to={redirectPath}/>
    );
};
export default PrivateRoute;
