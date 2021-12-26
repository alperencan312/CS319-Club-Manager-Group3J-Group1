import { configureStore } from "@reduxjs/toolkit";
import userSlice from "./userSlice";
import announcmentsSlice from "./announcmentsSlice";
import activitiesSlice from "./activitiesSlice";
import universitiesSlice from "./universitiesSlice";
import clubSlice from "./clubSlice";
import { getDefaultMiddleware } from "@reduxjs/toolkit";
import myCalendarSlice from "./myCalendarSlice";
import activitySlice from "./activitySlice";
import profilSlice from "./profilSlice";

export const store = configureStore({
  reducer: {
    user: userSlice,
    activities: activitiesSlice,
    announcements: announcmentsSlice,
    universities: universitiesSlice,
    club: clubSlice,
    myCalendar: myCalendarSlice,
    activity: activitySlice,
    profil: profilSlice,
  },
  middleware: (getDefaultMiddleware) =>
    getDefaultMiddleware({
      serializableCheck: false,
    }),
});
