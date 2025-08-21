async function search() {
  const q = document.getElementById("query").value;
  const res = await fetch(`http://localhost:8080/api/search?query=${encodeURIComponent(q)}`);
  const data = await res.json();
  const results = document.getElementById("results");

  if (data.length === 0) {
    results.innerHTML = "<div class='card'>No results found.</div>";
    return;
  }

  results.innerHTML = data.map(c => `
    <div class="card">
      <h3>${c.name}</h3>
      <div><b>Capitals:</b> ${c.capitals.join(", ")}</div>
      ${c.formerCapitals.length ? `<div><b>Former:</b> ${c.formerCapitals.join(", ")}</div>` : ""}
      ${c.notes ? `<div class="muted">Note: ${c.notes}</div>` : ""}
    </div>
  `).join("");
}
