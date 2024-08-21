import React, { useState, useEffect } from 'react';
import { NavLink as ReactLink, useNavigate } from 'react-router-dom';
import {
    Collapse,
    Navbar,
    NavbarToggler,
    NavbarBrand,
    Nav,
    NavItem,
    NavLink,
} from 'reactstrap';
import { toast } from 'react-toastify';
import { logout } from '../Service/UserService';

function CustomNavbar() {
    const [isOpen, setIsOpen] = useState(false);
    const [user, setUser] = useState(null);
    const navigate = useNavigate();

    const toggle = () => setIsOpen(!isOpen);

    useEffect(() => {
        // Check if user data exists in localStorage
        const storedUser = localStorage.getItem('user');
        if (storedUser) {
            setUser(JSON.parse(storedUser));
        }
    }, []);

    const handleLogout = () => {
        logout().then(() => {
            setUser(null); // Clear the user state
            localStorage.removeItem('user'); // Remove user from localStorage
            toast.success("Logged out successfully");
            navigate('/login'); // Redirect to login page after logout
        }).catch((error) => {
            toast.error("Error during logout");
            console.error("Logout error:", error);
        });
    };

    return (
        <div>
            <Navbar color="success" light expand="md">
                <NavbarBrand tag={ReactLink} to="/">foody</NavbarBrand>
                <NavbarToggler onClick={toggle} />
                <Collapse isOpen={isOpen} navbar>
                    <Nav className="me-auto" navbar>
                        <NavItem>
                            <NavLink tag={ReactLink} to="/">Home</NavLink>
                        </NavItem>
                        <NavItem>
                            <NavLink tag={ReactLink} to="/order">Food Item</NavLink>
                        </NavItem>
                        {/* Conditionally render based on user state */}
                    </Nav>

                    <Nav navbar>
                        {user ? (
                            <>
                                <NavItem>
                                    <NavLink >{/*tag={ReactLink} to={`/user/profileInfo/${user.id}`} */}
                                        {user.name}
                                    </NavLink>
                                </NavItem>
                                <NavItem>
                                    <NavLink type="button" onClick={handleLogout}>
                                        Logout
                                    </NavLink>
                                </NavItem>
                            </>
                        ) : (
                            <>
                                <NavItem>
                                    <NavLink className="text-white" tag={ReactLink} to="/login">
                                        Login
                                    </NavLink>
                                </NavItem>
                                <NavItem>
                                    <NavLink className="text-white" tag={ReactLink} to="/signup">
                                        Signup
                                    </NavLink>
                                </NavItem>
                            </>
                        )}
                    </Nav>
                </Collapse>
            </Navbar>
        </div>
    );
}

export default CustomNavbar;
