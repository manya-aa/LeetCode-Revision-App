const BASE_URL = "http://localhost:8080";

export async function getProblems() {
  const res = await fetch(`${BASE_URL}/showProb`);
  return res.json();
}

export async function submitProblems(ids) {
  await fetch(`${BASE_URL}/submit`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(ids)
  });
}

export async function addProblem(problem) {
  const res = await fetch(`${BASE_URL}/addProb`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(problem)
  });
  return res.json();
}

