export function setCurrentPage() {
  const navLinks = document.querySelectorAll('.nav-link')

  navLinks.forEach((link) => {
    if (link.href === window.location.href) {
      link.classList.add('active')
    }
  })
}


export function onScroll() {
  if (scrollY > 0) {
    navbar.classList.add('scrolled')
  } else {
    navbar.classList.remove('scrolled')
  }
}