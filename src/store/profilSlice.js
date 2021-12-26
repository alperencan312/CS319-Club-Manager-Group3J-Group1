import { createSlice } from "@reduxjs/toolkit";

const initialState = {
  data: {},
  openProfilModal: false,
};

const profilSlice = createSlice({
  name: "profil",
  initialState,
  reducers: {
    setOpenProfilModal: (state, action) => {
      state.openProfilModal = action.payload;
    },
    setProfilData: (state, action) => {
      state.data = action.payload;
    },
  },
});

// Action creators are generated for each case reducer function

export default profilSlice.reducer;
export const { setOpenProfilModal, setProfilData } = profilSlice.actions;
