import faker from "faker";
import { v4 as uuidv4 } from "uuid";

export const data = [
  {
    id: uuidv4(),
    name: faker.name.findName(),
    School: "Bilkent University",
    SchoolId: faker.datatype.uuid(),
    profilPicture: faker.image.image(),
    clubsSubscribed: ["MT Bilkent", "Outdoor Sports", "MT ITU"],
    clubsDirected: ["ITU Bees"],
  },
  {
    id: uuidv4(),
    name: faker.name.findName(),
    School: "Bilkent University",
    SchoolId: faker.datatype.uuid(),
    profilPicture: faker.image.image(),
    clubsSubscribed: ["MT Bilkent", "Outdoor Sports", "MT ITU"],
    clubsDirected: ["ITU Bees"],
  },
  {
    id: uuidv4(),
    name: faker.name.findName(),
    School: "Bilkent University",
    SchoolId: faker.datatype.uuid(),
    profilPicture: faker.image.image(),
    clubsSubscribed: ["MT Bilkent", "Outdoor Sports", "MT ITU"],
    clubsDirected: ["ITU Bees"],
  },
  {
    id: uuidv4(),
    name: faker.name.findName(),
    School: "Bilkent University",
    SchoolId: faker.datatype.uuid(),
    profilPicture: faker.image.image(),
    clubsSubscribed: ["MT Bilkent", "Outdoor Sports", "MT ITU"],
    clubsDirected: ["ITU Bees"],
  },
  {
    id: uuidv4(),
    name: faker.name.findName(),
    School: "Bilkent University",
    SchoolId: faker.datatype.uuid(),
    profilPicture: faker.image.image(),
    clubsSubscribed: [
      "English Speaking Club",
      "Google Developer Student Clubs",
    ],
    clubsDirected: ["MT Bilkent"],
  },
  {
    id: uuidv4(),
    name: faker.name.findName(),
    School: "Bilkent University",
    SchoolId: faker.datatype.uuid(),
    profilPicture: faker.image.image(),
    clubsSubscribed: [
      "English Speaking Club",
      "Google Developer Student Clubs",
    ],
    clubsDirected: ["MT Bilkent"],
  },
  {
    id: uuidv4(),
    name: faker.name.findName(),
    School: "Bilkent University",
    SchoolId: faker.datatype.uuid(),
    profilPicture: faker.image.image(),
    clubsSubscribed: [
      "English Speaking Club",
      "Google Developer Student Clubs",
    ],
    clubsDirected: ["MT Bilkent"],
  },
  {
    id: uuidv4(),
    name: faker.name.findName(),
    School: "Bilkent University",
    SchoolId: faker.datatype.uuid(),
    profilPicture: faker.image.image(),
    clubsSubscribed: [
      "English Speaking Club",
      "Google Developer Student Clubs",
    ],
    clubsDirected: ["MT Bilkent"],
  },
];


