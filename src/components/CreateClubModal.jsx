import {
  Autocomplete,
  Button,
  Chip,
  FormControl,
  FormControlLabel,
  IconButton,
  Input,
  InputLabel,
  MenuItem,
  Modal,
  OutlinedInput,
  Select,
  Stack,
  Switch,
  TextareaAutosize,
  TextField,
  Typography,
} from "@mui/material";
import React, { useEffect, useState } from "react";
import CloseIcon from "@mui/icons-material/Close";
import { Box } from "@mui/system";
import ImageIcon from "@mui/icons-material/Image";
import { useDispatch } from "react-redux";
import { addClub } from "../store/universitiesSlice";

export default function CreateClubModal({ open, setOpen, location }) {
  const dispatch = useDispatch();
  const [keyWords, setKeyWords] = useState([]);
  const [image, setImage] = useState();
  const [name, setName] = useState("");
  const [type, setType] = useState("Club");
  const [acceptOthers, setAcceptOthers] = useState(false);
  const [information, setInformation] = useState("");

  const onTagsChange = (event, values) => {
    const newValues = values.map((item) => item.toLowerCase());
    setKeyWords(newValues);
  };

  const handleSubmit = () => {
    if (name.length <= 0 || information.length <= 0 || keyWords.length <= 0) {
    } else {
      dispatch(
        addClub({
          universityIndex: location,
          name,
          type: type,
          information,
          acceptOthers,
          keyWords,
        })
      );
      setName("");
      setInformation("");
      setKeyWords([]);
    }
  };

  return (
    <Modal
      open={open}
      onClose={() => {
        setOpen(false);
      }}
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
          p: 7,
        }}
      >
        <CloseIcon
          sx={{
            position: "absolute",
            right: 5,
            top: 5,
            fontSize: 48,
            color: "purple",
            cursor: "pointer",
          }}
          onClick={() => {
            setOpen(false);
          }}
        />
        <Stack alignItems={"center"} spacing={8}>
          <Typography variant="h4">
            <span style={{ color: "#2074d4", fontWeight: "500" }}>
              CREATE A CLUB
            </span>
          </Typography>
          <Box
            sx={{
              width: "100%",
              display: "flex",
              justifyContent: "space-between",
            }}
          >
            <Stack spacing={2} direction="column">
              <Box
                sx={{
                  backgroundColor: "white",
                  width: "250px",
                  height: "250px",
                }}
              ></Box>
              <Box
                sx={{
                  width: "100%",
                  display: "flex",
                  justifyContent: "center",
                }}
              >
                <IconButton sx={{ backgroundColor: "#2074d4" }}>
                  <input
                    accept="image/png, image/gif, image/jpeg"
                    type="file"
                    id="file"
                    style={{ display: "none" }}
                  />
                  <InputLabel
                    htmlFor="file"
                    sx={{
                      width: "100%",
                      height: "100%",
                      cursor: "pointer",
                      display: "flex",
                      justifyContent: "center",
                      alignItems: "center",
                    }}
                  >
                    <ImageIcon color="action" />
                  </InputLabel>
                </IconButton>
              </Box>
            </Stack>

            <Stack
              spacing={2}
              sx={{
                border: "3px solid black",
                p: "25px",
                width: "600px",
                minHight: "500px",
              }}
              justifyContent={"center"}
            >
              <Box
                sx={{
                  width: "100%",
                  display: "flex",
                  justifyContent: "center",
                }}
              >
                <Typography variant="h5">
                  <span style={{ color: "#2074d4" }}>CLUB FORM</span>
                </Typography>
              </Box>
              <FormControl>
                <InputLabel htmlFor="name">Name: </InputLabel>
                <OutlinedInput
                  id="name"
                  label="Name"
                  value={name}
                  onChange={(e) => setName(e.target.value)}
                />
              </FormControl>
              <FormControl>
                <InputLabel htmlFor="type">Type: </InputLabel>
                <Select
                  labelId="demo-simple-select-label"
                  id="type"
                  label="Type"
                  defaultValue={type}
                  value={type}
                  onChange={(e) => setType(e.target.value)}
                >
                  <MenuItem value={"Club"}>Club</MenuItem>
                  <MenuItem value={"Organization"}>Organization</MenuItem>
                  <MenuItem value={"Company"}>Company</MenuItem>
                </Select>
              </FormControl>

              <FormControl>
                <TextareaAutosize
                  sx={{ padding: "15px" }}
                  placeholder="Information: "
                  style={{ width: "100%", height: "100px" }}
                  value={information}
                  onChange={(e) => setInformation(e.target.value)}
                />
              </FormControl>
              <FormControl>
                <Autocomplete
                  multiple
                  limitTags={4}
                  id="tags-filled"
                  freeSolo
                  onChange={onTagsChange}
                  options={keyWords.map((option) => option)}
                  defaultValue={[]}
                  renderTags={(value, getTagProps) =>
                    value.map((option, index) => (
                      <Chip
                        variant="outlined"
                        label={option}
                        {...getTagProps({ index })}
                      />
                    ))
                  }
                  renderInput={(params) => (
                    <TextField
                      {...params}
                      variant="outlined"
                      label="Key Words:"
                    />
                  )}
                />
              </FormControl>
              <Stack direction="row" spacing={1} alignItems="center">
                <Switch
                  value={acceptOthers}
                  onClick={() => {
                    setAcceptOthers(!acceptOthers);
                  }}
                />
                {acceptOthers ? (
                  <Typography>Accept Students From Outside</Typography>
                ) : (
                  <Typography>Does Not Accept Students From Outside</Typography>
                )}
              </Stack>
            </Stack>
          </Box>
          <Button variant="contained" onClick={handleSubmit}>
            Make a Request
          </Button>
        </Stack>
      </Box>
    </Modal>
  );
}
