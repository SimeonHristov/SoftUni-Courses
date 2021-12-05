const movieList = document.getElementById('movieList')
const searchBar = document.getElementById('searchInput')

const allMovies = [];

fetch("http://localhost:8080/movies/api").
then(response => response.json()).
then(data => {
  for (let movie of data) {
    allMovies.push(movie);
  }
})

console.log(allMovies);

searchBar.addEventListener('keyup', (e) => {
  const searchingCharacters = searchBar.value.toLowerCase();
  let filteredMovies = allMovies.filter(movie => {
    return movie.name.toLowerCase().includes(searchingCharacters)
        || movie.director.toLowerCase().includes(searchingCharacters);
  });
  displayMovies(filteredMovies);
})


const displayMovies = (movies) => {
  movieList.innerHTML = movies
      .map((m) => {
        return ` <div class="col-md-3" >
                <div class="card mb-4 box-shadow">
                <img src="${m.poster}" class="card-img-top" alt="Thumbnail [100%x225]"
                     data-holder-rendered="true"
                     style="height: 225px; width: 100%; display: block;">
                <div class="card-body">
                    <div class="text-center">
                        <p class="card-text border-bottom ">Name: ${m.name}</p>
                        <p class="card-text border-bottom ">Director: ${m.director}</p>
                        <p class="card-text border-bottom ">Genre: ${m.genre}</p>
                        <p class="card-text border-bottom ">Rating: ${m.rating}</p>
                        <p class="card-text border-bottom">Release Date: ${m.releaseDate}</p>
                    </div>
                    <div class="d-flex justify-content-between align-items-center">

                        <div class="btn-group">
                            <a href="/movies/details/${m.id}"  type="button" class="btn btn-sm btn-outline-secondary">Details</a>
                        </div>
                        <div class="btn-group">
                            <a href="/movies/delete/${m.id}"  type="button" class="btn btn-sm btn-outline-secondary">Delete</a>
                        </div>

                    </div>
                </div>
            </div>
            </div>`
      })
      .join('');

}
