import { Modal, Typography } from "@material-ui/core";
import { Image } from "@material-ui/icons";
import { Avatar, Box, Stack } from "@mui/material";
import React, { useEffect, useState } from "react";
import HomeIcon from "@mui/icons-material/Home";
import EventIcon from "@mui/icons-material/Event";
import PeopleIcon from "@mui/icons-material/People";
import SettingsIcon from "@mui/icons-material/Settings";
import ChatBubbleIcon from "@mui/icons-material/ChatBubble";
import CloseIcon from "@mui/icons-material/Close";
import { useDispatch, useSelector } from "react-redux";
import { setClub, setOpenModal } from "../store/clubSlice";
import { Route, Routes, useLocation, useNavigate } from "react-router-dom";
import ClubModalHome from "./ClubModalHome";
import ClubModalPeople from "./ClubModalPeople";
import ClubModalSettings from "./ClubModalSettings";
import ClubModalCalendar from "./ClubModalCalendar";
export default function ClubModal() {
  const navigate = useNavigate();
  const clubLocation = useLocation().pathname.split("/")[2];
  const universityLocation = useLocation().pathname.split("/")[1];
  const { isLoading, data } = useSelector((state) => state.club);

  const universityData = useSelector((state) => state.universities.data);
  const dispatch = useDispatch();

  useEffect(() => {
    dispatch(
      setClub(
        universityData[universityLocation].clubs.find(
          (item) => item.clubId == clubLocation
        )
      )
    );
  }, [clubLocation, universityLocation, universityData, dispatch]);

  useEffect(() => {
    return () => {
      dispatch(setClub(null));
    };
  }, [data, dispatch]);

  const handleClose = () => {
    navigate(`../${universityLocation}`);
  };

  return (
    <Modal
      open={data != null}
      onClose={handleClose}
      aria-labelledby="modal-modal-title"
      aria-describedby="modal-modal-description"
    >
      <Box
        sx={{
          position: "absolute",
          top: "50%",
          left: "58%",
          transform: "translate(-50%, -50%)",
          border: "solid 3px black",
          backgroundColor: "#f8e4e4",
          width: "1100px",
          height: "800px",
          p: 6,
        }}
      >
        <CloseIcon
          sx={{
            position: "absolute",
            right: 5,
            top: 5,
            fontSize: 48,
            color: "#2074d4",
            cursor: "pointer",
          }}
          onClick={() => {
            navigate(`../${universityLocation}`);
          }}
        />

        {isLoading ? (
          <Box
            sx={{
              width: "100%",
              height: "100%",
              display: "flex",
              justifyContent: "center",
              alignItems: "center",
            }}
          >
            <h1>Loading...</h1>
          </Box>
        ) : (
          <>
            <Box sx={{ display: "flex", justifyContent: "space-between" }}>
              <img
                alt="club"
                src={data?.clubImg}
                style={{ width: "200px", height: "200px" }}
              />

              <Stack spacing={2} justifyContent="center">
                <Typography variant="h4">
                  <span style={{ color: "#2074d4" }}>{data?.clubName}</span>
                </Typography>
                <Typography variant="h5" sx={{ display: "flex" }}>
                  <span style={{ color: "#2074d4", fontWeight: "bold" }}>
                    Type:
                  </span>{" "}
                  {data?.type}
                </Typography>
                <Typography variant="h5">
                  <span style={{ color: "#2074d4", fontWeight: "bold" }}>
                    School:
                  </span>{" "}
                  {data?.school}
                </Typography>
              </Stack>
              <Stack
                spacing={3}
                direction="row"
                justifyContent="center"
                sx={{ px: 5 }}
              >
                <Stack
                  spacing={1}
                  alignItems="center"
                  sx={{ cursor: "pointer" }}
                >
                  <HomeIcon
                    fontSize="large"
                    onClick={() => {
                      navigate(`/${universityLocation}/${clubLocation}`);
                    }}
                    style={{ color: "#2074d4" }}
                  />
                  <Typography variant="body1">Home</Typography>
                </Stack>
                <Stack
                  spacing={1}
                  alignItems="center"
                  sx={{ cursor: "pointer" }}
                >
                  <EventIcon fontSize="large" style={{ color: "#2074d4" }}
                    onClick={() => {
                      navigate(
                        `/${universityLocation}/${clubLocation}/calendar`
                      );
                    }}
                  />
                  <Typography variant="body1">Calendar</Typography>
                </Stack>
                <Stack
                  spacing={1}
                  alignItems="center"
                  sx={{ cursor: "pointer" }}
                >
                  <PeopleIcon
                    fontSize="large"
                    onClick={() => {
                      navigate(
                        `/${universityLocation}/${clubLocation}/members`
                      );
                    }}
                    style={{ color: "#2074d4" }}
                  />
                  <Typography variant="body1">People</Typography>
                </Stack>
                <Stack
                  spacing={1}
                  alignItems="center"
                  sx={{ cursor: "pointer" }}
                >
                  <SettingsIcon fontSize="large" style={{ color: "#2074d4" }}
                    onClick={() => {
                      navigate(
                        `/${universityLocation}/${clubLocation}/settings`
                      );
                    }}
                  />
                  <Typography variant="body1">Settings</Typography>
                </Stack>
                <Stack
                  spacing={1}
                  alignItems="center"
                  sx={{ cursor: "pointer" }}
                >
                  <ChatBubbleIcon
                    fontSize="large"
                    style={{ color: "#2074d4" }}
                  />
                  <Typography variant="body1">Chat</Typography>
                </Stack>
              </Stack>
            </Box>
            <Routes>
              <Route path={`/`} element={<ClubModalHome data={data} />} />
              <Route
                path={`/calendar`}
                element={<ClubModalCalendar clubData={data}/>}
              />
              <Route
                path={`/members`}
                element={<ClubModalPeople data={data} />}
              />
              <Route
                path={`/settings`}
                element={<ClubModalSettings />}
              />

            </Routes>
          </>
        )}
      </Box>
    </Modal>
  );
}
