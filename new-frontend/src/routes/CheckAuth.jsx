import React from 'react';
import { Navigate, Outlet } from 'react-router-dom';
import { useDispatch, useSelector } from 'react-redux';


const CheckAuth = () => {
  const loggedIn = useSelector((state) => state.auth.loggedIn);

  
 // If user is authenticated, render the nested components
  // Otherwise, redirect to login page
  return loggedIn ? <Outlet /> : <Navigate to="/login" replace/>;
};

export default CheckAuth;
