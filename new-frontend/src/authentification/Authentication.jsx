import React, { useState } from 'react'
import { z } from 'zod';
import Login from './Login';
import Register from './Register';
const Authentication = () => {
    
    const [activeSection, setActiveSection] = useState(window.location.pathname);

  // Schema validation for login form
  const loginSchema = z.object({
    username: z.string().min(3, "Username must be at least 3 characters long"),
    password: z.string().min(6, "Password must be at least 6 characters long"),
  });
    

  return (
    <div>Authentication

    {activeSection === '/login' ? <Login /> : <Register />}

    </div>
  )
}

export default Authentication