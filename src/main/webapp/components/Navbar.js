import { navLinks } from "../scripts/data.js"

export const Navbar = () => {
  let links = []

  navLinks.map(({ texto, link }) => {
    links.push(
      `
      <li class="nav-item  fs-4">
        <a class="nav-link" href="../${link}/${link === 'home' ? 'index' : link}.html">${texto}</a>
      </li>
      `
    )
  })
  links = links.join(' ')
  return `
  <nav class="navbar navbar-dark navbar-expand-lg" id="navbar">
      <div class="container">
        <a class="navbar-brand" id="logo-mobile" href="../home/index.html">
          <img src="../../assets/plane.png" alt="Daviagens logo" width="30" height="30">
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasTop"
          aria-controls="offcanvasTop">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="offcanvas offcanvas-top" tabindex="-1" id="offcanvasTop" aria-labelledby="offcanvasTopLabel">
          <div class="container">
            <div class="offcanvas-header">
              <a class="navbar-brand" id="logo-mobile" href="../home/index.html">
                <img src="../../assets/plane.png" alt="Daviagens logo" width="30" height="30">
              </a>
              <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
            </div>
            <ul class="navbar-nav text-uppercase mx-auto mb-2 mb-lg-0">
              ${links}
            </ul>
          </div>
        </div>
      </div>
    </nav>
  `
}