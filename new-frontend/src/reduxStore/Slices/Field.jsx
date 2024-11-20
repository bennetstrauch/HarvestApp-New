import { createSlice } from "@reduxjs/toolkit";

// # true for dev. purposes
const initialAuthState = { loggedIn: true };

const authSlice = createSlice(
    {
        name: 'authentication',
        initialState: initialAuthState,
        reducers: {
            loginSuccessful(state) {
                state.loggedIn = true
            },
            logout(state) {
                state.loggedIn = false;
            }
        }
    }
);

export default authSlice;