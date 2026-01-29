import {addProblem} from "./api.js";

const btn = document.getElementById("addProbBtn");
const probNoInput = document.getElementById("probNo");
const probUrlInput = document.getElementById("probUrl");
const probNameInput = document.getElementById("probName");
btn.addEventListener("click", async () => {

  const probNo = probNoInput.value.trim();
  const probUrl = probUrlInput.value.trim();
  const probName = probNameInput.value.trim()
  if (!probNo || !probUrl || !probName) {
    alert("Fill all fields");
    return;
  }
  const problem = {
    prob_no: probNo,
    url: probUrl,
    prob_name: probName
  };

  try {
    const saved = await addProblem(problem);
    console.log("Saved:", saved);
    alert("Problem added successfully");
  } catch (e) {
    console.error(e);
    alert("Error adding problem");
  }
});