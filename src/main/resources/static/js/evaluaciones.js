//Funcion del aux
const validadoNota= (nota) =>{
    if (nota<1 || nota > 7){
        return false;
    }
    else if(nota%1 !==0){//nota entera
        return false;
        
    }
    
    return true;

}



const agregarNota = async (event) => {
  event.preventDefault(); 
  const form = event.target; 
  const evaluacion = form.querySelector('input[name="eval"]'); 
  const notaValue = evaluacion.value;

  let isValid = validadoNota(notaValue); 
   if (!isValid) {
        alert('La nota debe ser un número entero entre 1 y 7.');
        return;
      }

  try {
    let formData = new FormData(form);
    const response = await fetch(form.action, { 
            method: form.method || 'POST',
            body: formData
        });
   
    
    if (response.ok) {
      console.log('Nota agregada');
      
      alert('Nota agregada');
    
      form.reset();
      const actividadId = form.querySelector('input[name="actividadId"]').value;
      await recalcularPromedio(actividadId);
    } else {
      console.error('Error en la agregar nota');
      alert('Error en la agregar nota');
    }
    
  } catch (error) {
    console.error('Error:', error);
    alert('Error de conexión');
  }
};


const recalcularPromedio = async (actividadId) =>{
  const response = await fetch(`/api/actividad/${actividadId}/promedio`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            }
        });
        
        if (response.ok) {
            const data = await response.json();
            const notas = data.notas || [];

             if (!Array.isArray(notas) || notas.length === 0) {
                console.warn(`No se encontraron notas para la actividad ${actividadId}. Mostrando '-'.`);
                const promedioEnHtml = document.querySelector(`tr[data-actividad-id="${actividadId}"] .promedio`);
                 promedioEnHtml.textContent = "-";
                return; 
            }
            const suma = notas.reduce((acc, nota) => acc + nota.nota, 0);
            const promedio = suma / notas.length;
            const promedioEnHtml = document.querySelector(`tr[data-actividad-id="${actividadId}"] .promedio`);
    
            promedioEnHtml.textContent = promedio.toFixed(2);
    

}


}
document.addEventListener('DOMContentLoaded', async () => {
    const evalForms = document.querySelectorAll('.eval-form');
    evalForms.forEach(form => {
        form.addEventListener('submit', agregarNota);
    });

   
    const actividadRows = document.querySelectorAll('tr[data-actividad-id]');
    for (const row of actividadRows) {
        const actividadId = row.dataset.actividadId; 
        await recalcularPromedio(actividadId); 
    }
})