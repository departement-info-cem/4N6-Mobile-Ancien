package org.sbac.quizzz;

import org.sbac.model.*;
import org.sbac.transfert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@Transactional
public class ServiceQuiz {

    public static class Existing extends Exception { }

    @Autowired          DepotUtilisateur depotUtilisateur;
    @Autowired          DepotQuiz depotQuiz;
    @Autowired          DepotQuestion depotQuestion;

    public QuizDetail detail(Long id, MUtilisateur user) {
        MQuiz q = user.quizs.stream().filter(elt -> elt.id == id).findFirst().get();
        QuizDetail response = new QuizDetail();
        response.nom = q.nom;
        response.id = q.id;
        response.nombreQuestions = q.questions.size();
        response.questions = new ArrayList<>();
        for (MQuestion question : q.questions) {
            response.questions.add(question.contenu);
        }
        return response;
    }

    public void creerQuiz(CreerQuizReq req, MUtilisateur user) throws Existing {
        req.nom = req.nom.trim();
        if (req.nom.trim().length() == 0) throw new IllegalArgumentException();
        for (MQuiz b : user.quizs) {
            if (b.nom.equalsIgnoreCase(req.nom)) throw new Existing();
        }
        // Tout est bon, on crée le quiz
        MQuiz q = new MQuiz();
        q.nom = req.nom;
        user.quizs.add(q);
        depotUtilisateur.save(user);
    }

    public void modifierQuestion(ModifierQuestionReq request, MUtilisateur utilisateurActuel) throws IllegalAccessException {
        MQuestion question = depotQuestion.findById(request.questionID).get();
        if (!estAuteur(question, utilisateurActuel)) {
            throw new IllegalAccessException();
        }
        question.contenu = request.nouvelleQuestion;
        depotQuestion.save(question);
    }

    public void ajouterQuestion(AjouterQuestionReq request, MUtilisateur utilisateurActuel) throws IllegalAccessException {
        MQuiz q = depotQuiz.findById(request.quizID).get();
        if (!estAuteur(q, utilisateurActuel)) {
            throw new IllegalAccessException();
        }
        MQuestion question = new MQuestion();
        question.contenu = request.question;
        question.date = new Date();
        q.questions.add(question);
        depotQuiz.save(q);
    }

    public List<QuizResume> accueil(Long idUtilisateur) {
        MUtilisateur utilisateur = depotUtilisateur.findById(idUtilisateur).get();
        List<QuizResume> res = new ArrayList<>();
        for (MQuiz q : utilisateur.quizs) {
            QuizResume r = new QuizResume();
            r.id = q.id;
            r.nom = q.nom;
            r.nombreQuestions = q.questions.size();
            res.add(r);
        }
        return res;
    }

    private boolean estAuteur(MQuiz quiz, MUtilisateur utilisateur){
        for (MQuiz q : utilisateur.quizs) {
            if (q.id == quiz.id) return true;
        }
        return false;
    }

    private boolean estAuteur(MQuestion question, MUtilisateur utilisateur){
        MQuiz quiz = depotQuiz.findByQuestionsId(question.id).get();
        return estAuteur(quiz, utilisateur);
    }

    public MUtilisateur utilisateurParSonNom(String nom) {
        return depotUtilisateur.findByNomUtilisateur(nom).get();
    }

}
