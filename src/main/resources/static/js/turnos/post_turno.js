window.addEventListener("load", function () {
  //Al cargar la pagina buscamos y obtenemos el formulario donde estarán
  //los datos que el usuario cargará del nuevo odontologo
  const formulario = document.querySelector("#add_new_turno");
  const pacienteList = document.querySelector("#paciente-list")
  const odontologoList = document.querySelector("#odontologo-list")
  //Ante un submit del formulario se ejecutará la siguiente funcion
  formulario.addEventListener("submit", function (event) {
    //creamos un JSON que tendrá los datos de un nuevo turno
    const formData = {
      fecha: document.querySelector("#fecha").value,
      hora: document.querySelector("#hora").value,
      paciente: {
        id: document.querySelector("#paciente-list").value,
      },
      odontologo: {
        id: document.querySelector("#odontologo-list").value,
      },
    };
    console.log(formData);

    const url = "/turnos";
    const settings = {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(formData),
    };

    fetch(url, settings)
      .then((response) => response.json())
      .then((data) => {
        //Si no hay ningun error se muestra un mensaje diciendo que el odontologo
        //se agrego bien
        let successAlert =
          '<div class="alert alert-success alert-dismissible">' +
          '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
          "<strong></strong> Turno agregado </div>";

        document.querySelector("#response").innerHTML = successAlert;
        document.querySelector("#response").style.display = "block";
        resetUploadForm();

      })
      
      .catch((error) => {
        //Si hay algun error se muestra un mensaje diciendo que el odontologo
        //no se pudo guardar y se intente nuevamente
        let errorAlert =
          '<div class="alert alert-danger alert-dismissible">' +
          '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
          "<strong> Error intente nuevamente</strong> </div>";

        document.querySelector("#response").innerHTML = errorAlert;
        document.querySelector("#response").style.display = "block";
        //se dejan todos los campos vacíos por si se quiere ingresar otro odontologo
        resetUploadForm();
      });

   
  });

  function resetUploadForm() {
    document.querySelector("#fecha").value = "";
    document.querySelector("#hora").value = "";
    document.querySelector("#paciente-list").value = "";
    document.querySelector("#odontologo-list").value = "";
  }

  (function () {
    let pathname = window.location.pathname;
    if (pathname === "/") {
      document.querySelector(".nav .nav-item a:first").addClass("active");
    } else if (pathname == "/turnos.html") {
      document.querySelector(".nav .nav-item a:last").addClass("active");
    }
  })();


  const urlPaciente = "/pacientes";
  const settingsPaciente = {
    method: "GET",
  };
  fetch(urlPaciente, settingsPaciente)
    .then((response) => response.json())
    .then((data) => {
      //recorremos la colección de odontologos del JSON
      for (paciente of data) {
        pacienteList.appendChild(
          new Option(paciente.nombre + " " + paciente.apellido,
            paciente.id )
        );
      }
    });

  const urlOdontologo = "/odontologos";
  const settingsOdontologo = {
    method: "GET",
  };
  fetch(urlOdontologo, settingsOdontologo)
    .then((response) => response.json())
    .then((data) => {
      //recorremos la colección de odontologos del JSON
      for (odontologo of data) {
        odontologoList.appendChild(new Option(odontologo.nombre +" " +odontologo.apellido, odontologo.id)
        );
      }
    });

});
