import { createSlice } from "@reduxjs/toolkit";

const initialState = {
  data: {},
  openActivityModal: false,
};

const activitySlice = createSlice({
  name: "activity",
  initialState,
  reducers: {
    setopenActivityModal: (state, action) => {
      state.openActivityModal = action.payload;
    },
    setActivityData: (state, action) => {
      state.data = action.payload;
    },
  },
});

// Action creators are generated for each case reducer function

export default activitySlice.reducer;
export const { setopenActivityModal, setActivityData } = activitySlice.actions;
