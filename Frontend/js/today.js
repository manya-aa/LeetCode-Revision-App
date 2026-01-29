import { getProblems, submitProblems } from "./api.js";

const listDiv = document.getElementById("problemList");
const submitBtn = document.getElementById("submitBtn");

let selected = [];

function toggle(id) {
  selected.includes(id)
    ? selected = selected.filter(x => x !== id)
    : selected.push(id);
}

getProblems().then(problems => {
  problems.forEach(p => {
    const row = document.createElement("div");
    const cb = document.createElement("input");
    cb.type = "checkbox";
    cb.onchange = () => toggle(p.prob_no);
        const a = document.createElement("a");
          a.href = p.url;
          a.textContent = p.prob_name;
          a.target = "_blank";
    row.append(cb, a);
          listDiv.appendChild(row);
  });
});

submitBtn.onclick = () => submitProblems(selected);
