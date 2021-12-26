import { createSlice } from "@reduxjs/toolkit";
import axios from 'axios';

/*axios.get("http://localhost:8080/announcements").then(res => initialState);*/

const initialState = {

  data: [
    {
      clubImg:
        "https://www.startupnedir.com/wp-content/uploads/2018/11/bilkent-yes.jpg",
      title: "Bilkent YES",
      announcment:
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
      sent: '1 week ago',
    },
    {
      clubImg:
        "https://pbs.twimg.com/profile_images/480050296702259200/mag5F_xR_400x400.png",
      title: "MT Bilkent",
      announcment:
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
      sent: '2 weeks ago',
    },
    {
      clubImg:
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ_fDnrffcoVUYZBH_WLWJg72n4QXuf_K3ZDQ&usqp=CAU",
      title: "DSC Club",
      announcment:
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
      sent: '2 weeks ago',
    },
  ],
  
};

const announcementsSlice = createSlice({
  name: "announcements",
  initialState,
  reducers: {},
});

// Action creators are generated for each case reducer function

export default announcementsSlice.reducer;
