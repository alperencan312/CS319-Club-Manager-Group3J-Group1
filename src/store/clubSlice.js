import { createSlice } from "@reduxjs/toolkit";

const initialState = {
  data: null,
  openModal: false,
  isLoading: true,
};

const clubSlice = createSlice({
  name: "club",
  initialState,
  reducers: {
    setClub: (state, action) => {
      state.data = action.payload;
      state.isLoading = false;
    },
    setOpenModal: (state, action) => {
      state.openModal = action.payload;
    },
  },
});

// Action creators are generated for each case reducer function

export default clubSlice.reducer;
export const { setClub, setOpenModal } = clubSlice.actions;
