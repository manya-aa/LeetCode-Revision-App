const canvas = document.getElementById("bg-canvas");
const ctx = canvas.getContext("2d");

ctx.imageSmoothingEnabled = false;

function resize() {
  canvas.width = window.innerWidth;
  canvas.height = window.innerHeight;
}
resize();
window.addEventListener("resize", resize);

const ghostImg = new Image();
ghostImg.src = "../assets/ghost.png";

const ghost = {
  x: Math.random() * window.innerWidth,
  y: Math.random() * window.innerHeight,
  vx: -1.5,
  vy: 1,
  t: Math.random() * 1000,
  scale: 7
};

function updateGhost() {
  ghost.t += 0.015;

  ghost.x += ghost.vx + Math.sin(ghost.t) * 0.25;
  ghost.y += ghost.vy + Math.cos(ghost.t * 1.2) * 0.3;

  if (ghost.x > canvas.width + 40) ghost.x = -40;
  if (ghost.y > canvas.height + 40) ghost.y = -40;
  if (ghost.x < -40) ghost.x = canvas.width + 40;
  if (ghost.y < -40) ghost.y = canvas.height + 40;
}

function drawGhost(x, y, scale) {
  const baseSize = 16;
  const size = baseSize * scale;

  const px = Math.round(x / 2) * 2;
  const py = Math.round(y / 2) * 2;

  const bob = Math.sin(ghost.t) * 3;

  ctx.globalAlpha = 0.85;
  ctx.shadowColor = "rgba(255,255,255,0.4)";
  ctx.shadowBlur = 6;

  ctx.drawImage(ghostImg, px, py + bob, size, size);

  ctx.shadowBlur = 0;
  ctx.globalAlpha = 1;
}

function animate() {
  ctx.clearRect(0, 0, canvas.width, canvas.height);
  updateGhost();
  drawGhost(ghost.x, ghost.y, ghost.scale);
  setTimeout(() => requestAnimationFrame(animate), 40);
}

ghostImg.onload = animate;
