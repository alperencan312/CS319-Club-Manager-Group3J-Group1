import { createSlice } from "@reduxjs/toolkit";


const initialState = {
  username: "admin",
  password: "123456",
  name: "Caitlyn Kerluke",
  School: "Bilkent University",
  SchoolId: "21802124",
  clubsSubscribed: [
    "English Speaking Club",
    "Google Developer Student Clubs",
  ],
  clubsDirected: ["MT Bilkent"],
  profilPicture:
    "https://img.freepik.com/free-photo/pleasant-looking-serious-man-stands-profile-has-confident-expression-wears-casual-white-t-shirt_273609-16959.jpg?size=626&ext=jpg",
  loggedIn: window.localStorage.getItem("loggedIn") || false,
};


const userSlice = createSlice({
  name: "user",
  initialState,
  reducers: {
    login: (state, action) => {
      if (
        action.payload.username == state.username &&
        action.payload.password == state.password
      ) {
        state.loggedIn = true;
        window.localStorage.setItem("loggedIn", true);
      }
    },
    logout: (state, action) => {
      state.loggedIn = false;
      window.localStorage.removeItem("loggedIn");
    },
  },
});

// Action creators are generated for each case reducer function

export default userSlice.reducer;
export const { login, logout } = userSlice.actions;
