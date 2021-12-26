import { createSlice } from "@reduxjs/toolkit";

const initialState = {
  data: [
    {
      clubImg:
        "https://pbs.twimg.com/profile_images/1083258175963447296/ZBxRqk5o_400x400.jpg",
      title: "Outdoor Sports",
      day: "Today",
      time: "18:30",
    },
    {
      clubImg:
        "https://pbs.twimg.com/profile_images/480050296702259200/mag5F_xR_400x400.png",
      title: "MT Bilkent",
      day: "Tomorrow",
      time: "21:00",
    },
    {
      clubImg:
        "https://www.wellesley.edu/sites/default/files/assets/departments/psychology/images/psych-club.jpg",
      title: "Psychology Club",
      day: "Wednesday",
      time: "21:00",
    },
    {
      clubImg:
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ_fDnrffcoVUYZBH_WLWJg72n4QXuf_K3ZDQ&usqp=CAU",
      title: "Google Development",
      day: "Tuesday",
      time: "18:00",
    },
  ],  
};

const activitiesSlice = createSlice({
  name: "activities",
  initialState,
  reducers: {
    setActivityData:(state,action) => {
      state.activityData = action.payload;
    }
  },
});

// Action creators are generated for each case reducer function

export default activitiesSlice.reducer;
export const {setActivityData} = activitiesSlice.actions;
