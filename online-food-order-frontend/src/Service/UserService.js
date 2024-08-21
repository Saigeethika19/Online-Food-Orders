import { myAxios } from "./Helper"

export const signup = (user) => {
    return myAxios.post("/user/create-user", user).then((response) => response.data);
}
// Method for user login
export const mylogin = (credentials) => {
    return myAxios.post("/user/login", credentials).then((response) => response.data);
};


export const logout = () => {
    // Remove user data from localStorage
    localStorage.removeItem('user');
    // No need to make an API call, just resolve immediately
    return Promise.resolve(true);
};
