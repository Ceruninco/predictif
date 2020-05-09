
            $(document).ready( function () {
                $('#bouton-inscription').on( 'click', function () { // Fonction appelée lors du clic sur le bouton

                    console.log("clic sur le bouton d'inscription"); // LOG dans Console Javascript
                    $('#notification').html("Inscription..."); // Message pour le paragraphe de notification

                    // Récupération de la valeur des champs du formulaire
                    var champNom = $('#champ-nom').val();
                    var champPrenom = $('#champ-prenom').val();
                    var champCivilite = $('#champ-civilite').val();
                    var champNaissance = $('#champ-naissance').val();
                    var champAdressePostale = $('#champ-adressepostale').val();
                    var champNumTelephone = $('#champ-numtelephone').val();
                    var champAdresseMail = $('#champ-adressemail').val();
                    var champPassword = $('#champ-password').val();

                    // Appel AJAX
                    $.ajax({
                        url: './ActionServlet',
                        method: 'GET',
                        data: {
                            todo: 'inscrire',
                            nom : champNom,
                            prenom : champPrenom,
                            civilite : champCivilite,
                            dateDeNaissance : champNaissance,
                            adressePostale : champAdressePostale,
                            numTelephone : champNumTelephone,
                            adresseMail : champAdresseMail,
                            password: champPassword
                        },
                        dataType : 'json'
                    })
                    .done( function (response) { // Fonction appelée en cas d'appel AJAX réussi
                        console.log('Response',response); // LOG dans Console Javascript

                        if (response.connexion) {
                            $('#notification').html("Connexion OK");  // Message pour le paragraphe de notification
                            $('#id').html("Connexion de " + response.client.id);
                            $('#nom').html("nom : " + response.client.nom + " ,prenom :" + response.client.prenom);
                            $('#mail').html("adresse mail : " + response.client.mail);
                            // TODO: afficher les informations du client dans la notification
                            // Exemple: Connexion de Ada Lovelace (ID 1)
                        }
                        else {
                            $('#notification').html("Erreur de Connexion"); // Message pour le paragraphe de notification
                        }
                    })
                    .fail( function (error) { // Fonction appelée en cas d'erreur lors de l'appel AJAX
                        console.log('Error',error); // LOG dans Console Javascript
                        alert("Erreur lors de l'appel AJAX"+error.status);
                    })
                    .always( function () { // Fonction toujours appelée
                        
                    })
                });
            });