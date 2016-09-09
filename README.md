# pokeapi-bilac
API Rest para a semana de Tecnologia do Bilac

### Endpoints

**GET** - http://pokeapi-bilac.herokuapp.com/api/pokemon

> Busca todos os pokémons cadastrados na base

**GET** - http://pokeapi-bilac.herokuapp.com/api/pokemon?page=__numeroDaPag__&size=__sizeDaBusca__

> Busca os pokémons cadastrados na base, por paginação e size
 * http://pokeapi-bilac.herokuapp.com/api/pokemon?page=0&size=1
 * http://pokeapi-bilac.herokuapp.com/api/pokemon?page=3

**GET** - http://pokeapi-bilac.herokuapp.com/api/pokemon/hateoas

> Busca os pokémons cadastrados na base com hateoas.

**GET** - http://pokeapi-bilac.herokuapp.com/api/pokemon/hateoas?page=__numeroDaPag__&size=__sizeDaBusca__

> Busca os pokémons cadastrados na base, por paginação, size e com hateoas
* http://pokeapi-bilac.herokuapp.com/api/pokemon/hateoas?page=0&size=1
* http://pokeapi-bilac.herokuapp.com/api/pokemon/hateoas?page=3

**GET** - http://pokeapi-bilac.herokuapp.com/api/pokemon/{name}

> Busca os pokémons cadastrados na base com hateoas pelo nome.

**POST** - http://pokeapi-bilac.herokuapp.com/api/pokemon

> Cadastra um pokemon. Passar no body o objeto *json*

```

	{
		"nome" : "Hoppip", 
		"evolucaoNome": "skiploom",
		"categoria":"Cottonweed",
		"habilidade":"Chlorophyll",
		"altura": "0.5",
		"peso": "0.4",
		"tipo":["Grass", "Flying"],
		"fraquezas": ["Ice", "Fire", "Flying", "Poison", "Rock"],
		"sexo": ["M", "F"]	
	}
```

**PUT** - http://pokeapi-bilac.herokuapp.com/api/pokemon

> Edita um pokemon. Passar no body o objeto *json*

```

	{
		"id": 1,
		"nome" : "Hoppip", 
		"evolucaoNome": "skiploom",
		"categoria":"Cottonweed",
		"habilidade":"Chlorophyll",
		"altura": "0.5",
		"peso": "0.4",
		"tipo":["Grass", "Flying"],
		"fraquezas": ["Ice", "Fire", "Flying", "Poison", "Rock"],
		"sexo": ["M", "F"]
	}
```

**DELETE** - http://pokeapi-bilac.herokuapp.com/api/pokemon/{id}

> Delete um pokemon pelo id. 
Ex:. http://pokeapi-bilac.herokuapp.com/api/pokemon/1




