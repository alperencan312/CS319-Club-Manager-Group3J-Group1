import {
  Button,
  Box,
  Modal,
  TextareaAutosize,
  InputLabel,
  FormControl,
  MenuItem,
  Select,
  OutlinedInput,
  Stack,
} from "@mui/material";
import { useState } from "react";

function Event({ show, setShow }) {
  const [type, setType] = useState("");
  const [participant, setParticipant] = useState("");
  const [name, setName] = useState("");

  const handleClose = () => {
    setShow(false);
  };
  return (
    <Modal
      open={show}
      onClose={handleClose}
      sx={{ display: "flex", alignItems: "center", justifyContent: "center" }}
    >
      <Box
        sx={{
          width: "500px",
          minHeight: "550px",
          maxHeight: "800px",
          backgroundColor: "white",
          border: "3px solid black",
          display: "flex",
          alignItems: "center",
          justifyContent: "center",
        }}
      >
        <form style={{ width: "100%", height: "100%", padding: "10px" }}>
          <Stack spacing={2}>
            <FormControl fullWidth>
              <InputLabel htmlFor="name">Name:</InputLabel>
              <OutlinedInput id="name" label="Name" />
            </FormControl>
            <FormControl fullWidth>
              <InputLabel>Location :</InputLabel>
              <OutlinedInput sx={{ width: "100%" }}></OutlinedInput>
            </FormControl>
            <FormControl fullWidth>
              <InputLabel htmlFor="priority">Priority</InputLabel>
              <Select
                sx={{ width: "100%" }}
                onChange={(e) => setType(e.target.value)}
                defaultValue={type}
                value={type}
                direction="column"
                label="Priority:"
                id="priority"
              >
                <MenuItem value={"Require"}>Required</MenuItem>
                <MenuItem value={"NotRequire"}>Not Required</MenuItem>
              </Select>
            </FormControl>
            <FormControl fullWidth>
              <InputLabel htmlFor="participants">Participants</InputLabel>
              <Select
                sx={{ width: "100%" }}
                onChange={(e) => setParticipant(e.target.value)}
                defaultValue={participant}
                value={participant}
                direction="column"
                label="Participants:"
                id="participants"
              >
                <MenuItem value={"admin"}>Only Admins</MenuItem>
                <MenuItem value={"everyone"}>Everyone</MenuItem>
              </Select>
            </FormControl>
            <FormControl fullWidth>
              <InputLabel>Information</InputLabel>
              <TextareaAutosize
                sx={{ padding: "15px" }}
                style={{ width: "100%", height: "100px" }}
              />
            </FormControl>
          </Stack>

          <Button
            variant="contained"
            sx={{ width: "100%", mt: "20px" }}
            type="submit"
          >
            Create
          </Button>
        </form>
      </Box>
    </Modal>
  );
}

export default Event;
