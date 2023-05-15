import React from "react";
import {Navigate} from "react-router-dom";

interface PublicRouteProps {
    isAuthenticated: boolean;
    redirectPath: string;
    component: React.ComponentType<any>;
}

const PublicRoute: React.FC<PublicRouteProps> = ({
                                                     isAuthenticated,
                                                     redirectPath,
                                                     component: Component
                                                 }) => (
    !isAuthenticated ? <Component/> : <Navigate to={redirectPath}/>
);
export default PublicRoute;