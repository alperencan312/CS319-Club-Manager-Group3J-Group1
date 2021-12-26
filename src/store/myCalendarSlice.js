import { createSlice } from "@reduxjs/toolkit";

const initialState = {
  openCalendarModal: false,
};

const myCalendarSlice = createSlice({
  name: "myCalendar",
  initialState,
  reducers: {
    setOpenCalendarModal: (state, action) => {
      state.openCalendarModal = action.payload;
    },
  },
});

// Action creators are generated for each case reducer function

export default myCalendarSlice.reducer;
export const {setOpenCalendarModal} = myCalendarSlice.actions;
