var QualPostTraining = QualPostTraining || (function($) {
	var app, prd, data = { list: null, item: null };

	/**
	 * Render
	 * @param params Parameters
	 * @function
	 */
	function render(params, qualTemplate) {
		
		try {
			if (typeof Vue === 'undefined') throw 'Vue.js not available';
			
			if (!params.pub) $('#demovuejsfrontend').css('min-height', '1000px');

			/*app = app || (params.pub
					? new Simplicite.Ajax(params.root, 'api', 'website', 'simplicite')  // External
					: Simplicite.Application  // Internal
				);*/
			app = new Simplicite.Ajax(params.root, 'uipublic');
			
			let output = [];
			let exams = params.exams;
			let tmp;
			let unknown = false;
			let generic = params.generic;
			
			let exObjRowId = "";
			let usrExObjIds = [];
			
			if("" == exams){
				unknown = true;
				completed = true;
		    	submitted = true;
				start =  new FlowForm.QuestionModel({
					id: 'start',
					title: "Oups... ",
					content: "Il semblerait y avoir un problème avec l'affichage de votre questionnaire. Il est possible que votre token soit inexistant ou ait expiré.",
					type: FlowForm.QuestionType.SectionBreak,
					required: false,
				})
				output.push(start);
			}
			else{
				
				if(generic){
					start = new FlowForm.QuestionModel({
			            id: 'start',
			            title: "Bonjour "+String.fromCodePoint("0x1F44B"),
			            subtitle:"Vous avez suivi une formation sur la plateforme Simplicité et nous aimerions avoir votre avis sur celle-ci. Ces quelques questions on pour but d'améliorer notre processus de formation. Bien entendu, il n'y a pas de bonnes ou de mauvaises réponses "+String.fromCodePoint(0x1F642),
			            description:"D'avance merci pour votre temps !",
			            type: FlowForm.QuestionType.SectionBreak,
			            required: true,
	        		});
				}
				else{
					start = new FlowForm.QuestionModel({
			            id: 'start',
			            tagline:"Bonjour "+String.fromCodePoint("0x1F44B"),
			            title: "Bienvenue sur le portail de questionnaires Simplicité.",
		            	subtitle: "Vous allez ici répondre à un certain nombre de questions nous permettant d'évaluer votre niveau de compréhension de la plateforme.",
		            	description:"Lorsque vous êtes prêts, cliquez sur 'suivant' ou Appuyez sur la touche ENTRÉE pour commencer.",
			            type: FlowForm.QuestionType.SectionBreak,
			            required: true,
	        		});
				}
        	
				output.push(start);
				
				for(let k = 0; k < exams.length; k++){
					let input = exams[k].questions;
					let examTitle = exams[k].examTitle;
					for(let i = 0; i < input.length; i++){
						if(input[i].type == "ENUM"){
							let choices = [];
							let iChoices = input[i].enum.split("@@@");
							for(let j = 0; j<iChoices.length; j++){
								tmpChoice = new FlowForm.ChoiceOption({
									label: iChoices[j], 
								}),
								choices.push(tmpChoice);
							}
							tmp = new FlowForm.QuestionModel({
								examId : exams[k].examId,
								id: input[i].id,
								title: input[i].title,
								helpTextShow: false,
								type: FlowForm.QuestionType.MultipleChoice,
								required: true,
								multiple: false,
								options: choices,
						    })
						}
						else if(input[i].type == "TXT"){
							tmp = new FlowForm.QuestionModel({
								examId : exams[k].examId,
								id:input[i].id,
								title: input[i].title,
								type: FlowForm.QuestionType.LongText,
								required: true
								
						    })
						}
						else if(input[i].type == "QST_BREAK"){
							tmp = new FlowForm.QuestionModel({
								id : "exam-"+exams[k].examId +"-break",
								examId : exams[k].examId,
					            title: examTitle,
					            description: exams[k].examDescription,
					            type: FlowForm.QuestionType.SectionBreak,
			        		});
						}
						
						
						output.push(tmp);
					}
				}
			}
			
			let languageParams = new FlowForm.LanguageModel({
				enterKey: 'Entrée',
			    shiftKey: 'Maj',
		        continue: 'Suivant',
		        pressEnter: 'Appuyez sur :enterKey',
		        otherPrompt: 'Autre',
		        submitText: 'Valider',
			    placeholder : 'Saisissez votre réponse ici...',
			    percentCompleted : ':percent% complété',
			    multipleChoiceHelpTextSingle : 'Choisissez une valeur',
			    longTextHelpText : ':shiftKey + :enterKey pour aller à la ligne.'
			})
			
			new Vue({
				el: '#app',
				template:qualTemplate,
				data: function() {
					return {
						loading:false,
						scored: false,
						submitted: false,
						completed: false,
						language: languageParams,
						questions: output,
						isValid: !unknown,
						generic:params.generic,
						scores:[]
					}
				},
				
				methods: {
				
				 onAnswer(qA) {
				 	let id = qA.id;
				 	
					if(qA.type == FlowForm.QuestionType.SectionBreak && qA.id.includes("exam")){
						//create exam in back
						var usrExObj = app.getBusinessObject("QualUserExam");
						usrExObj.resetFilters();
						usrExObj.getForCreate(function () {
							usrExObj.item.qualUsrexamUsrId = params.userId;
							usrExObj.item.qualUsrexamExamId = qA.examId;
							usrExObj.create(function(){
								exObjRowId = usrExObj.getRowId();
								usrExObjIds.push(exObjRowId);
							}, usrExObj.item);
							
						});
					}
					
					if(qA.type !== FlowForm.QuestionType.SectionBreak){
						//question answered -> set value in back
						let submittedValue = qA.answer;
						var usrAnswerObj = app.getBusinessObject("QualExUsr");
						usrAnswerObj.resetFilters();
						usrAnswerObj.search(function(){
							usrAnswerObj.getForUpdate(function(){
								usrAnswerObj.item.qualExusrSubmitted = true;
								usrAnswerObj.item.qualExusrAnswer = submittedValue;
								usrAnswerObj.update();
							}, usrAnswerObj.list[0].row_id);
						}, 
						{
							qualExusrUsrexamId:exObjRowId,
							qualExusrExamexId__qualExamexExId__qualExId:qA.id
						});
						
					}
				},
					
			      onComplete(completed, questionList) {
			        // This method is called whenever the "completed" status is changed.
			        this.completed = completed
			        if(this.generic){
			        	this.onQuizSubmit();
			        }
			      },
			      
			      onQuizSubmit() {
			        // Set `submitted` to true so the form knows not to allow back/forward
			        // navigation anymore.
			        this.$refs.flowform.submitted = true
			        
			        this.submitted = true
			        if(!unknown){
			        	this.validateExams();
			        	exams.forEach(exam => {
			        		examQuestions = [];
			        		this.questions.forEach(qst => {
			        			if(qst.examId == exam.examId && qst.type !== FlowForm.QuestionType.SectionBreak){
			        				examQuestions.push(qst);
			        			}
			        		});
			        		if(!generic){
			        			let examScore = this.calculateScore(exam, examQuestions);
								this.scores.push(examScore);
			        		}
			        		//this.store(exam, examQuestions);
			        	})
			        	this.scored = true;
			        }
			      },
			      
			      calculateScore(exam, qsts){
			      	score = 0;
			      	total = qsts.length;
			      	qsts.forEach(qst =>{
			      		let answer = qst.answer;
			      		if (answer == exam.answers[qst.id]) {
			              score++
			            }
			      	});
			      	score = Math.round((score / total)*100);
			      	return {"examId": exam.examId, "examTitle": exam.examTitle, "score": score};
			      	//each exam has a specific score;
			      },
			
				validateExams(){
					this.loading = true;
			      	//set ended for all exams
		    		var obj = app.getBusinessObject("QualUserExam");
	    			obj.resetFilters();
			      	usrExObjIds.forEach(id => {
						obj.getForUpdate(function(){
							obj.item.qualUsrexamEtat = "DONE";
							obj.update();
						},id);
					});
					
					//display "wait" section
					setTimeout(() => {
						this.loading = false;
					}, 1000)
					
				},
				
			      store(exam, qsts){
			      	
			      	this.loading = true;
			      	/*console.log("storing " + exam.examId);
		    		var usrExObj = app.getBusinessObject("QualUserExam");
		    		var usrExObjIds = [];
			      	usrExObj.resetFilters();
					usrExObj.getForCreate(function () {
						usrExObj.item.qualUsrexamUsrId = params.userId;
						usrExObj.item.qualUsrexamExamId = exam.examId;
						usrExObj.create(function(){
							//callback of creation -> answer items should have been created
							usrExObjIds.push(usrExObj.getRowId());
							qsts.forEach(function(qst, index){
								if (qst.type !== FlowForm.QuestionType.SectionBreak) {
									if(qst.examId == exam.examId){
										let submittedValue = qst.answer;
										var usrAnswerObj = app.getBusinessObject("QualExUsr");
										usrAnswerObj.resetFilters();
										usrAnswerObj.search(function(){
											usrAnswerObj.getForUpdate(function(){
												usrAnswerObj.item.qualExusrSubmitted = true;
												usrAnswerObj.item.qualExusrAnswer = submittedValue;
												usrAnswerObj.update(function(){
													if(index === qsts.length - 1){
														
														usrExObjIds.forEach(id => {
															usrExObj.getForUpdate(function(){
																usrExObj.item.qualUsrexamEtat = "DONE";
																usrExObj.update();
															},id);
														});
													}
												});
											}, usrAnswerObj.list[0].row_id);
										}, 
										{
											qualExusrUsrexamId:usrExObj.getRowId(),
											qualExusrExamexId__qualExamexExId__qualExId:qst.id
										});
									}
								}
							})
						}, usrExObj.item);
					});*/
					
					//display "wait" section
					setTimeout(() => {
						this.loading = false;
					}, 1000)
					
			      },
			      
			      
			    },
			    
			});
			 
		} catch(e) {
			console.error('Render error: ' + e.message);
		}
		
		
	}

	return { render: render };	
})(jQuery);