package wc2014;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultListModel;

public class WorldCup2014 extends javax.swing.JFrame implements ActionListener {
    ArrayList<Team> teams = new ArrayList<Team>();
    
    ArrayList<GroupTeam> groupA = new ArrayList<GroupTeam>();
    ArrayList<GroupTeam> groupB = new ArrayList<GroupTeam>();
    ArrayList<GroupTeam> groupC = new ArrayList<GroupTeam>();
    ArrayList<GroupTeam> groupD = new ArrayList<GroupTeam>();
    ArrayList<GroupTeam> groupE = new ArrayList<GroupTeam>();
    ArrayList<GroupTeam> groupF = new ArrayList<GroupTeam>();
    ArrayList<GroupTeam> groupG = new ArrayList<GroupTeam>();
    ArrayList<GroupTeam> groupH = new ArrayList<GroupTeam>();
    
    ArrayList [] groups = { groupA, groupB, groupC, groupD, groupE, groupF, groupG, groupH };
    
    ArrayList<PlayOffTeam> last16 = new ArrayList<PlayOffTeam>();
    ArrayList<PlayOffTeam> last8 = new ArrayList<PlayOffTeam>();
    ArrayList<PlayOffTeam> last4 = new ArrayList<PlayOffTeam>();
    ArrayList<PlayOffTeam> last2third = new ArrayList<PlayOffTeam>();
    ArrayList<PlayOffTeam> last2 = new ArrayList<PlayOffTeam>();
    
    DefaultTableModel tableInfoModel1 = new DefaultTableModel();
    DefaultTableModel tableInfoModel2 = new DefaultTableModel();
    DefaultTableModel tableInfoModel3 = new DefaultTableModel();
    DefaultTableModel tableInfoModel4 = new DefaultTableModel();
    DefaultTableModel tableInfoModel5 = new DefaultTableModel();
    DefaultTableModel tableInfoModel6 = new DefaultTableModel();
    DefaultTableModel tableInfoModel7 = new DefaultTableModel();
    DefaultTableModel tableInfoModel8 = new DefaultTableModel();
    
    DefaultTableModel [] tableInfoModel = { tableInfoModel1, tableInfoModel2,
        tableInfoModel3, tableInfoModel4, tableInfoModel5, tableInfoModel6,
        tableInfoModel7, tableInfoModel8 };
    
    DefaultListModel groupInfoModel1 = new DefaultListModel();
    DefaultListModel groupInfoModel2 = new DefaultListModel();
    DefaultListModel groupInfoModel3 = new DefaultListModel();
    DefaultListModel groupInfoModel4 = new DefaultListModel();
    DefaultListModel groupInfoModel5 = new DefaultListModel();
    DefaultListModel groupInfoModel6 = new DefaultListModel();
    DefaultListModel groupInfoModel7 = new DefaultListModel();
    DefaultListModel groupInfoModel8 = new DefaultListModel();
    DefaultListModel playOffInfoModel1 = new DefaultListModel();
    DefaultListModel playOffInfoModel2 = new DefaultListModel();
    DefaultListModel playOffInfoModel3 = new DefaultListModel();
    DefaultListModel playOffInfoModel4 = new DefaultListModel();
    DefaultListModel playOffInfoModel5 = new DefaultListModel();
    
    DefaultListModel [] listInfoModel = { groupInfoModel1, groupInfoModel2,
        groupInfoModel3, groupInfoModel4, groupInfoModel5, groupInfoModel6,
        groupInfoModel7, groupInfoModel8 };
    
    DefaultListModel [] playOffListInfoModel = { playOffInfoModel1, playOffInfoModel2,
        playOffInfoModel3, playOffInfoModel4, playOffInfoModel5};
    
    String [] groupNames = { "A", "B", "C", "D", "E", "F", "G", "H" };
    
    String [] teamsGroupA = { "Бразилия", "Хорватия", "Мексика", "Камерун" };
    String [] teamsGroupB = { "Испания", "Нидерланды", "Чили", "Австралия" };
    String [] teamsGroupC = { "Колумбия", "Греция", "Кот-д'Ивуар", "Япония" };
    String [] teamsGroupD = { "Уругвай", "Коста-Рика", "Англия", "Италия" };
    String [] teamsGroupE = { "Швейцария", "Эквадор", "Франция", "Гондурас" };
    String [] teamsGroupF = { "Аргентина", "Босния", "Иран", "Нигерия" };
    String [] teamsGroupG = { "Германия", "Португалия", "Гана", "США" };
    String [] teamsGroupH = { "Бельгия", "Алжир", "Россия", "Ю.Корея" };
    
    String [][] groupTeams = { teamsGroupA, teamsGroupB, teamsGroupC, teamsGroupD,
        teamsGroupE, teamsGroupF, teamsGroupG, teamsGroupH };

    
    public WorldCup2014() {
        initComponents();
        loadGroupRound("Savings/GroupRound.txt");
        if(isGroupsFinished()){
            loadPlayOffRound("Savings/Last16.txt", last16, "last16");
            loadPlayOffRound("Savings/Quarterfinal.txt", last8, "last8");
            loadPlayOffRound("Savings/Semifinal.txt", last4, "last4");
            loadPlayOffRound("Savings/ThirdPlace.txt", last2third, "last2third");
            loadPlayOffRound("Savings/Final.txt", last2, "last2");
        }
        for(int i=0; i<8; i++)
            fillTable(tableInfoModel[i], groupNames[i]);
        setTablesWidht();
        for(int i=0; i<8; i++)
            fillListGroup(groups[i], groupTeams[i], listInfoModel[i]);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButton2) {
            processMatchResult(groups[1], tableInfoModel[1], listInfoModel[1], jList2, jTextField2.getText().trim(), "B");
        }
        else if (e.getSource() == jButton3) {
            processMatchResult(groups[2], tableInfoModel[2], listInfoModel[2], jList3, jTextField3.getText().trim(), "C");
        }
        else if (e.getSource() == jButton4) {
            processMatchResult(groups[3], tableInfoModel[3], listInfoModel[3], jList4, jTextField4.getText().trim(), "D");
        }
        else if (e.getSource() == jButton5) {
            processMatchResult(groups[4], tableInfoModel[4], listInfoModel[4], jList5, jTextField5.getText().trim(), "E");
        }
        else if (e.getSource() == jButton6) {
            processMatchResult(groups[5], tableInfoModel[5], listInfoModel[5], jList6, jTextField6.getText().trim(), "F");
        }
        else if (e.getSource() == jButton7) {
            processMatchResult(groups[6], tableInfoModel[6], listInfoModel[6], jList7, jTextField7.getText().trim(), "G");
        }
        else if (e.getSource() == jButton8) {
            processMatchResult(groups[7], tableInfoModel[7], listInfoModel[7], jList8, jTextField8.getText().trim(), "H");
        }
        else if(e.getSource() == jButton9){
            processPlayOffResult(last16, playOffListInfoModel[0], jList9, jTextField9.getText().trim());
        }
        else if(e.getSource() == jButton10){
            processPlayOffResult(last8, playOffListInfoModel[1], jList10, jTextField10.getText().trim());
        }
        else if(e.getSource() == jButton11){
            processPlayOffResult(last4, playOffListInfoModel[2], jList11, jTextField11.getText().trim());
        }
        else if(e.getSource() == jButton13){
            processPlayOffResult(last2third, playOffListInfoModel[4], jList14, jTextField13.getText().trim());
        }
        else if(e.getSource() == jButton12){
            processPlayOffResult(last2, playOffListInfoModel[3], jList12, jTextField12.getText().trim());
        }
        else if(e.getSource() == jMenuItem1) {
            saveFile("Savings/GroupRound.txt");
            if(isGroupsFinished()){
                savePlayOffRound("Savings/Last16.txt", last16);
                savePlayOffRound("Savings/Quarterfinal.txt", last8);
                savePlayOffRound("Savings/Semifinal.txt", last4);
                savePlayOffRound("Savings/ThirdPlace.txt", last2third);
                savePlayOffRound("Savings/Final.txt", last2);
            }
        }
        else if(e.getSource() == jMenuItem3) {
            JOptionPane.showMessageDialog(this, "Чемпионат мира 2014: таблицы, результаты и статистика\n"
                    + "Версия: 1.0\nАвтор: Владимир Зайченко(http://vk.com/vladimir_vladimirovich_zaichenko)\n\n"
                    + "Для желающих отблагодарить материально:\nWebMoney - U227577213762, E187038158135\nЯндекс деньги - 410012330978570", "О программе",
                    JOptionPane.INFORMATION_MESSAGE, new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/facepalm.png")));
        }
        else if(e.getSource() == jMenuItem2) {
            setVisible(false);
            System.exit(0);
        }
    }
    
    public void updateStatistic(String command) {
        if(command.equals("clear")){
            jTextArea1.setText("");
            jLabelStat1.setIcon(null);
            jLabelStat2.setIcon(null);
            jLabelStat3.setIcon(null);
            jTextArea2.setText("");
            jLabelStat4.setIcon(null);
            jLabelStat5.setIcon(null);
            jLabelStat6.setIcon(null);
            jTextArea3.setText("");
            jLabelStat7.setIcon(null);
            jLabelStat8.setIcon(null);
            jLabelStat9.setIcon(null);
            jTextArea4.setText("");
            jLabelStat10.setIcon(null);
            jLabelStat11.setIcon(null);
            jLabelStat12.setIcon(null);
            jTextArea5.setText("");
            jLabelStat13.setIcon(null);
            jLabelStat14.setIcon(null);
            jLabelStat15.setIcon(null);
            jTextArea7.setText("");
            jLabelStat16.setIcon(null);
            jLabelStat17.setIcon(null);
            jLabelStat18.setIcon(null);
            jTextArea8.setText("");
            jLabelStat19.setIcon(null);
            jLabelStat20.setIcon(null);
            jLabelStat21.setIcon(null);
            return;
        }
         
        ArrayList<Team> copy = new ArrayList<Team>();
        
        //best by scored
        for (int i = 0; i < teams.size(); i++) {
            copy.add(teams.get(i));
            copy.get(i).setSortCriterion("Scored");
        }
        Collections.sort(copy, Collections.reverseOrder());
        jTextArea1.setText("");
        for(int i=0; i<3; i++){
            jTextArea1.append(copy.get(i).getTeamName() + " - " + copy.get(i).getGoalsFor() + " голов (" + copy.get(i).getMatchesPlayed() + " матчей)\n");
            if(i != 2)
                jTextArea1.append("\n");
        }
        jLabelStat1.setIcon(new javax.swing.ImageIcon(getClass().getResource(copy.get(0).getIconPath())));
        jLabelStat2.setIcon(new javax.swing.ImageIcon(getClass().getResource(copy.get(1).getIconPath())));
        jLabelStat3.setIcon(new javax.swing.ImageIcon(getClass().getResource(copy.get(2).getIconPath())));
        
        //best by conceded
        copy.clear();
        for (int i = 0; i < teams.size(); i++) {
            copy.add(teams.get(i));
            copy.get(i).setSortCriterion("Conceded");
        }
        Collections.sort(copy);
        jTextArea2.setText("");
        for(int i=0; i<3; i++){
            jTextArea2.append(copy.get(i).getTeamName() + " - " + copy.get(i).getGoalsAgainst() + " голов (" + copy.get(i).getMatchesPlayed() + " матчей)\n");
            if(i != 2)
                jTextArea2.append("\n");
        }
        jLabelStat4.setIcon(new javax.swing.ImageIcon(getClass().getResource(copy.get(0).getIconPath())));
        jLabelStat5.setIcon(new javax.swing.ImageIcon(getClass().getResource(copy.get(1).getIconPath())));
        jLabelStat6.setIcon(new javax.swing.ImageIcon(getClass().getResource(copy.get(2).getIconPath())));
        
        //worse by scored
        copy.clear();
        for (int i = 0; i < teams.size(); i++) {
            copy.add(teams.get(i));
            copy.get(i).setSortCriterion("Scored");
        }
        Collections.sort(copy);
        jTextArea7.setText("");
        for(int i=0; i<3; i++){
            jTextArea7.append(copy.get(i).getTeamName() + " - " + copy.get(i).getGoalsFor() + " голов (" + copy.get(i).getMatchesPlayed() + " матчей)\n");
            if(i != 2)
                jTextArea7.append("\n");
        }
        jLabelStat16.setIcon(new javax.swing.ImageIcon(getClass().getResource(copy.get(0).getIconPath())));
        jLabelStat17.setIcon(new javax.swing.ImageIcon(getClass().getResource(copy.get(1).getIconPath())));
        jLabelStat18.setIcon(new javax.swing.ImageIcon(getClass().getResource(copy.get(2).getIconPath())));
        
        //worse by conceded
        copy.clear();
        for (int i = 0; i < teams.size(); i++) {
            copy.add(teams.get(i));
            copy.get(i).setSortCriterion("Conceded");
        }
        Collections.sort(copy, Collections.reverseOrder());
        jTextArea8.setText("");
        for(int i=0; i<3; i++){
            jTextArea8.append(copy.get(i).getTeamName() + " - " + copy.get(i).getGoalsAgainst() + " голов (" + copy.get(i).getMatchesPlayed() + " матчей)\n");
            if(i != 2)
                jTextArea8.append("\n");
        }
        jLabelStat19.setIcon(new javax.swing.ImageIcon(getClass().getResource(copy.get(0).getIconPath())));
        jLabelStat20.setIcon(new javax.swing.ImageIcon(getClass().getResource(copy.get(1).getIconPath())));
        jLabelStat21.setIcon(new javax.swing.ImageIcon(getClass().getResource(copy.get(2).getIconPath())));
        
        //by wins
        copy.clear();
        for (int i = 0; i < teams.size(); i++) {
            copy.add(teams.get(i));
            copy.get(i).setSortCriterion("Wins");
        }
        Collections.sort(copy, Collections.reverseOrder());
        jTextArea3.setText("");
        for(int i=0; i<3; i++){
            jTextArea3.append(copy.get(i).getTeamName() + " - " + copy.get(i).getWins() + " (" + copy.get(i).getMatchesPlayed() + ")\n");
            if(i != 2)
                jTextArea3.append("\n");
        }
        jLabelStat7.setIcon(new javax.swing.ImageIcon(getClass().getResource(copy.get(0).getIconPath())));
        jLabelStat8.setIcon(new javax.swing.ImageIcon(getClass().getResource(copy.get(1).getIconPath())));
        jLabelStat9.setIcon(new javax.swing.ImageIcon(getClass().getResource(copy.get(2).getIconPath())));
        
        //by draws
        copy.clear();
        for (int i = 0; i < teams.size(); i++) {
            copy.add(teams.get(i));
            copy.get(i).setSortCriterion("Draws");
        }
        Collections.sort(copy, Collections.reverseOrder());
        jTextArea4.setText("");
        for(int i=0; i<3; i++){
            jTextArea4.append(copy.get(i).getTeamName() + " - " + copy.get(i).getDraws() + " (" + copy.get(i).getMatchesPlayed() + ")\n");
            if(i != 2)
                jTextArea4.append("\n");
        }
        jLabelStat10.setIcon(new javax.swing.ImageIcon(getClass().getResource(copy.get(0).getIconPath())));
        jLabelStat11.setIcon(new javax.swing.ImageIcon(getClass().getResource(copy.get(1).getIconPath())));
        jLabelStat12.setIcon(new javax.swing.ImageIcon(getClass().getResource(copy.get(2).getIconPath())));
        
        //by loses
        copy.clear();
        for (int i = 0; i < teams.size(); i++) {
            copy.add(teams.get(i));
            copy.get(i).setSortCriterion("Loses");
        }
        Collections.sort(copy, Collections.reverseOrder());
        jTextArea5.setText("");
        for(int i=0; i<3; i++){
            jTextArea5.append(copy.get(i).getTeamName() + " - " + copy.get(i).getLoses() + " (" + copy.get(i).getMatchesPlayed() + ")\n");
            if(i != 2)
                jTextArea5.append("\n");
        }
        jLabelStat13.setIcon(new javax.swing.ImageIcon(getClass().getResource(copy.get(0).getIconPath())));
        jLabelStat14.setIcon(new javax.swing.ImageIcon(getClass().getResource(copy.get(1).getIconPath())));
        jLabelStat15.setIcon(new javax.swing.ImageIcon(getClass().getResource(copy.get(2).getIconPath())));
    }
    
    void setTablesWidht() {
        int [] dimensions = {160, 18, 18, 18, 18, 33, 18, 18};
        for(int i=0; i<8; i++)
            jTable1.getColumnModel().getColumn(i).setMinWidth(dimensions[i]);
        for(int i=0; i<8; i++)
            jTable2.getColumnModel().getColumn(i).setMinWidth(dimensions[i]);
        for(int i=0; i<8; i++)
            jTable3.getColumnModel().getColumn(i).setMinWidth(dimensions[i]);
        for(int i=0; i<8; i++)
            jTable4.getColumnModel().getColumn(i).setMinWidth(dimensions[i]);
        for(int i=0; i<8; i++)
            jTable5.getColumnModel().getColumn(i).setMinWidth(dimensions[i]);
        for(int i=0; i<8; i++)
            jTable6.getColumnModel().getColumn(i).setMinWidth(dimensions[i]);
        for(int i=0; i<8; i++)
            jTable7.getColumnModel().getColumn(i).setMinWidth(dimensions[i]);
        for(int i=0; i<8; i++)
            jTable8.getColumnModel().getColumn(i).setMinWidth(dimensions[i]);
       
    }
    
    public void fillListGroup(ArrayList<GroupTeam> group, String [] matches, DefaultListModel listInfoModel) {
        String res1 = "-:-", res2 = "-:-", res3 = "-:-", res4 = "-:-", res5 = "-:-", res6 = "-:-";
        GroupTeam team1 = (GroupTeam)group.get(0);
        GroupTeam team2 = (GroupTeam)group.get(1);
        GroupTeam team3 = (GroupTeam)group.get(2);
        GroupTeam team4 = (GroupTeam)group.get(3);
        
        if(team1.getContenderName1().equals(matches[1]))
            res1 = team1.getLastScoreWithContender1().replace(';', ':');
        else if(team1.getContenderName2().equals(matches[1]))
            res1 = team1.getLastScoreWithContender2().replace(';', ':');
        else if(team1.getContenderName3().equals(matches[1]))
            res1 = team1.getLastScoreWithContender3().replace(';', ':');
        
        if(team3.getContenderName1().equals(matches[3]))
            res2 = team3.getLastScoreWithContender1().replace(';', ':');
        else if(team3.getContenderName2().equals(matches[3]))
            res2 = team3.getLastScoreWithContender2().replace(';', ':');
        else if(team3.getContenderName3().equals(matches[3]))
            res2 = team3.getLastScoreWithContender3().replace(';', ':');
        
        if(team1.getContenderName1().equals(matches[2]))
            res3 = team1.getLastScoreWithContender1().replace(';', ':');
        else if(team1.getContenderName2().equals(matches[2]))
            res3 = team1.getLastScoreWithContender2().replace(';', ':');
        else if(team1.getContenderName3().equals(matches[2]))
            res3 = team1.getLastScoreWithContender3().replace(';', ':');
        
        if(team4.getContenderName1().equals(matches[1]))
            res4 = team4.getLastScoreWithContender1().replace(';', ':');
        else if(team4.getContenderName2().equals(matches[1]))
            res4 = team4.getLastScoreWithContender2().replace(';', ':');
        else if(team4.getContenderName3().equals(matches[1]))
            res4 = team4.getLastScoreWithContender3().replace(';', ':');
        
        if(team4.getContenderName1().equals(matches[0]))
            res5 = team4.getLastScoreWithContender1().replace(';', ':');
        else if(team4.getContenderName2().equals(matches[0]))
            res5 = team4.getLastScoreWithContender2().replace(';', ':');
        else if(team4.getContenderName3().equals(matches[0]))
            res5 = team4.getLastScoreWithContender3().replace(';', ':');
        
        if(team2.getContenderName1().equals(matches[2]))
            res6 = team2.getLastScoreWithContender1().replace(';', ':');
        else if(team2.getContenderName2().equals(matches[2]))
            res6 = team2.getLastScoreWithContender2().replace(';', ':');
        else if(team2.getContenderName3().equals(matches[2]))
            res6 = team2.getLastScoreWithContender3().replace(';', ':');
       
        String [] matchResults = { matches[0] + " " + res1 + " " + matches[1],
            matches[2] + " " + res2 + " " + matches[3], matches[0] + " " + res3 + " " + matches[2],
            matches[3] + " " + res4 + " " + matches[1], matches[3] + " " + res5 + " " + matches[0],
            matches[1] + " " + res6 + " " + matches[2] };    
        
        for(int i = 0, j = 0; i<11; i++){
            if(i == 0 || i%2 == 0){
                listInfoModel.add(i, matchResults[j]);
                j++;
            }
            else
                listInfoModel.add(i, " ");
        }
    }
    
    public void fillTable(DefaultTableModel tableInfoModel, String groupName) {
        ArrayList<GroupTeam> sortedGroup = getSortedGroups(groupName);
        
        String team;
        int played;
        int wins;
        int loses;
        int draws;
        int scored;
        int conceded;
        int difference;
        int points;
        
        if (tableInfoModel.getColumnCount() == 0) {
            tableInfoModel.addColumn("Команда");
            tableInfoModel.addColumn("И");
            tableInfoModel.addColumn("В");
            tableInfoModel.addColumn("Н");
            tableInfoModel.addColumn("П");
            tableInfoModel.addColumn("Мячи");
            tableInfoModel.addColumn("РМ");
            tableInfoModel.addColumn("О");
        }
        
        if (tableInfoModel.getRowCount() > 0) {
            for (int i = tableInfoModel.getRowCount() - 1; i >= 0; i--) {
                tableInfoModel.removeRow(i);
            }
        }
        
        for (int i = 0; i < sortedGroup.size(); i++) {
            team = sortedGroup.get(i).getTeamName();
            played = sortedGroup.get(i).getMatchesPlayed();
            wins = sortedGroup.get(i).getWins();
            loses = sortedGroup.get(i).getLoses();
            draws = sortedGroup.get(i).getDraws();
            scored = sortedGroup.get(i).getGoalsFor();
            conceded = sortedGroup.get(i).getGoalsAgainst();
            String goals = (scored + ":" + conceded);
            difference = sortedGroup.get(i).getGoalDifference();
            points = sortedGroup.get(i).getPoints();
            tableInfoModel.addRow(new Object[]{ team, played, wins, draws, loses, goals, difference, points});
        }
    }
    
    public void fillPlayOffDefault(DefaultListModel listInfoModel, int rows) {
        jLabel46.setIcon(null);
        switch(rows) {
            case 7:
                jLabelPlayOff17.setIcon(null);
                jLabelPlayOff18.setIcon(null);
                jLabelPlayOff19.setIcon(null);
                jLabelPlayOff20.setIcon(null);
                jLabelPlayOff21.setIcon(null);
                jLabelPlayOff22.setIcon(null);
                jLabelPlayOff23.setIcon(null);
                jLabelPlayOff24.setIcon(null);
            case 3:
                jLabelPlayOff25.setIcon(null);
                jLabelPlayOff26.setIcon(null);
                jLabelPlayOff27.setIcon(null);
                jLabelPlayOff28.setIcon(null);
            case 1:
                jLabelPlayOff29.setIcon(null);
                jLabelPlayOff30.setIcon(null);
                jLabelPlayOff31.setIcon(null);
                jLabelPlayOff32.setIcon(null);
        }
        
        listInfoModel.clear();
        for(int i=0; i<rows; i++)
            listInfoModel.add(i, "");
    }
    
    public void fillPlayOffAfterLoad(ArrayList<PlayOffTeam> last, DefaultListModel listInfoModel) {
        for(int i=0; i<last.size(); i+=2) {
            if(last.get(i).getLastScoreWithContender().equals("-1;-1")){
                listInfoModel.add(i, last.get(i).getTeamName() + " -:- " + last.get(i+1).getTeamName());
                listInfoModel.add(i+1, " ");
            }
            else {
                if(last.get(i).getIsPenalty().equals("false")){
                    listInfoModel.add(i, last.get(i).getTeamName() + " " 
                            + last.get(i).getLastScoreWithContender().replace(';', ':') 
                            + " " + last.get(i+1).getTeamName());
                    listInfoModel.add(i+1, " ");
                }
                else {
                    listInfoModel.add(i, last.get(i).getTeamName() + " " + 
                                last.get(i).getLastScoreWithContender().replace(';', ':') + "("
                                + last.get(i).getLastPenaltyWithContender().replace(';', ':') + ") " 
                                + last.get(i + 1).getTeamName());
                    listInfoModel.add(i+1, " ");
                }
            }
            if(last.size() == 3)
                i++;
        }
        listInfoModel.removeElementAt(listInfoModel.size()-1);
        
        switch(last.size()) {
            case 16:
                jLabelPlayOff1.setIcon(new javax.swing.ImageIcon(getClass().getResource(last16.get(0).getIconPath())));
                jLabelPlayOff2.setIcon(new javax.swing.ImageIcon(getClass().getResource(last16.get(1).getIconPath())));
                jLabelPlayOff3.setIcon(new javax.swing.ImageIcon(getClass().getResource(last16.get(2).getIconPath())));
                jLabelPlayOff4.setIcon(new javax.swing.ImageIcon(getClass().getResource(last16.get(3).getIconPath())));
                jLabelPlayOff5.setIcon(new javax.swing.ImageIcon(getClass().getResource(last16.get(4).getIconPath())));
                jLabelPlayOff6.setIcon(new javax.swing.ImageIcon(getClass().getResource(last16.get(5).getIconPath())));
                jLabelPlayOff7.setIcon(new javax.swing.ImageIcon(getClass().getResource(last16.get(6).getIconPath())));
                jLabelPlayOff8.setIcon(new javax.swing.ImageIcon(getClass().getResource(last16.get(7).getIconPath())));
                jLabelPlayOff9.setIcon(new javax.swing.ImageIcon(getClass().getResource(last16.get(8).getIconPath())));
                jLabelPlayOff10.setIcon(new javax.swing.ImageIcon(getClass().getResource(last16.get(9).getIconPath())));
                jLabelPlayOff11.setIcon(new javax.swing.ImageIcon(getClass().getResource(last16.get(10).getIconPath())));
                jLabelPlayOff12.setIcon(new javax.swing.ImageIcon(getClass().getResource(last16.get(11).getIconPath())));
                jLabelPlayOff13.setIcon(new javax.swing.ImageIcon(getClass().getResource(last16.get(12).getIconPath())));
                jLabelPlayOff14.setIcon(new javax.swing.ImageIcon(getClass().getResource(last16.get(13).getIconPath())));
                jLabelPlayOff15.setIcon(new javax.swing.ImageIcon(getClass().getResource(last16.get(14).getIconPath())));
                jLabelPlayOff16.setIcon(new javax.swing.ImageIcon(getClass().getResource(last16.get(15).getIconPath())));
                break;
            case 8:
                jLabelPlayOff17.setIcon(new javax.swing.ImageIcon(getClass().getResource(last8.get(0).getIconPath())));
                jLabelPlayOff18.setIcon(new javax.swing.ImageIcon(getClass().getResource(last8.get(1).getIconPath())));
                jLabelPlayOff19.setIcon(new javax.swing.ImageIcon(getClass().getResource(last8.get(2).getIconPath())));
                jLabelPlayOff20.setIcon(new javax.swing.ImageIcon(getClass().getResource(last8.get(3).getIconPath())));
                jLabelPlayOff21.setIcon(new javax.swing.ImageIcon(getClass().getResource(last8.get(4).getIconPath())));
                jLabelPlayOff22.setIcon(new javax.swing.ImageIcon(getClass().getResource(last8.get(5).getIconPath())));
                jLabelPlayOff23.setIcon(new javax.swing.ImageIcon(getClass().getResource(last8.get(6).getIconPath())));
                jLabelPlayOff24.setIcon(new javax.swing.ImageIcon(getClass().getResource(last8.get(7).getIconPath())));
                break;
            case 4:
                jLabelPlayOff25.setIcon(new javax.swing.ImageIcon(getClass().getResource(last4.get(0).getIconPath())));
                jLabelPlayOff26.setIcon(new javax.swing.ImageIcon(getClass().getResource(last4.get(1).getIconPath())));
                jLabelPlayOff27.setIcon(new javax.swing.ImageIcon(getClass().getResource(last4.get(2).getIconPath())));
                jLabelPlayOff28.setIcon(new javax.swing.ImageIcon(getClass().getResource(last4.get(3).getIconPath())));
                break;
            case 3:
                jLabelPlayOff31.setIcon(new javax.swing.ImageIcon(getClass().getResource(last2third.get(0).getIconPath())));
                jLabelPlayOff32.setIcon(new javax.swing.ImageIcon(getClass().getResource(last2third.get(1).getIconPath())));
                break;
            case 2:
                jLabelPlayOff29.setIcon(new javax.swing.ImageIcon(getClass().getResource(last2.get(0).getIconPath())));
                jLabelPlayOff30.setIcon(new javax.swing.ImageIcon(getClass().getResource(last2.get(1).getIconPath())));
                if(last2.get(0).getIsWinner().equals("true")){
                    jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource(last2.get(0).getlargeIconPath())));
                    updateStatistic("update");
                }
                else if(last2.get(1).getIsWinner().equals("true")){
                    jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource(last2.get(1).getlargeIconPath())));
                    updateStatistic("update");
                }
                break;
        }
    }
    
    public void fillLast16() {
       last16.clear();
       last8.clear();
       last4.clear();
       last2.clear();
       playOffListInfoModel[0].clear();
       fillPlayOffDefault(playOffListInfoModel[1], 7);
       fillPlayOffDefault(playOffListInfoModel[2], 3);
       fillPlayOffDefault(playOffListInfoModel[3], 1);
       for(int i = 0, j = 0; i<groups.length; i++, j+=2) {
            switch(i) {
                case 0:
                    playOffListInfoModel[0].add(j, getSortedGroups("A").get(0).getTeamName() + " -:- " + getSortedGroups("B").get(1).getTeamName());
                    playOffListInfoModel[0].add(j + 1, " ");
                    jLabelPlayOff1.setIcon(new javax.swing.ImageIcon(getClass().getResource(getSortedGroups("A").get(0).getIconPath())));
                    jLabelPlayOff2.setIcon(new javax.swing.ImageIcon(getClass().getResource(getSortedGroups("B").get(1).getIconPath())));
                    last16.add(new PlayOffTeam(getSortedGroups("A").get(0).getTeamName()));
                    last16.add(new PlayOffTeam(getSortedGroups("B").get(1).getTeamName()));
                    break;
                case 1:
                    playOffListInfoModel[0].add(j, getSortedGroups("C").get(0).getTeamName() + " -:- " + getSortedGroups("D").get(1).getTeamName());
                    playOffListInfoModel[0].add(j + 1, " ");
                    jLabelPlayOff3.setIcon(new javax.swing.ImageIcon(getClass().getResource(getSortedGroups("C").get(0).getIconPath())));
                    jLabelPlayOff4.setIcon(new javax.swing.ImageIcon(getClass().getResource(getSortedGroups("D").get(1).getIconPath())));
                    last16.add(new PlayOffTeam(getSortedGroups("C").get(0).getTeamName()));
                    last16.add(new PlayOffTeam(getSortedGroups("D").get(1).getTeamName()));
                    break;
                case 2:
                    playOffListInfoModel[0].add(j, getSortedGroups("E").get(0).getTeamName() + " -:- " + getSortedGroups("F").get(1).getTeamName());
                    playOffListInfoModel[0].add(j + 1, " ");
                    jLabelPlayOff5.setIcon(new javax.swing.ImageIcon(getClass().getResource(getSortedGroups("E").get(0).getIconPath())));
                    jLabelPlayOff6.setIcon(new javax.swing.ImageIcon(getClass().getResource(getSortedGroups("F").get(1).getIconPath())));
                    last16.add(new PlayOffTeam(getSortedGroups("E").get(0).getTeamName()));
                    last16.add(new PlayOffTeam(getSortedGroups("F").get(1).getTeamName()));
                    break;
                case 3:
                    playOffListInfoModel[0].add(j, getSortedGroups("G").get(0).getTeamName() + " -:- " + getSortedGroups("H").get(1).getTeamName());
                    playOffListInfoModel[0].add(j + 1, " ");
                    jLabelPlayOff7.setIcon(new javax.swing.ImageIcon(getClass().getResource(getSortedGroups("G").get(0).getIconPath())));
                    jLabelPlayOff8.setIcon(new javax.swing.ImageIcon(getClass().getResource(getSortedGroups("H").get(1).getIconPath())));
                    last16.add(new PlayOffTeam(getSortedGroups("G").get(0).getTeamName()));
                    last16.add(new PlayOffTeam(getSortedGroups("H").get(1).getTeamName()));
                    break;
                case 4:
                    playOffListInfoModel[0].add(j, getSortedGroups("B").get(0).getTeamName() + " -:- " + getSortedGroups("A").get(1).getTeamName());
                    playOffListInfoModel[0].add(j + 1, " ");
                    jLabelPlayOff9.setIcon(new javax.swing.ImageIcon(getClass().getResource(getSortedGroups("B").get(0).getIconPath())));
                    jLabelPlayOff10.setIcon(new javax.swing.ImageIcon(getClass().getResource(getSortedGroups("A").get(1).getIconPath())));
                    last16.add(new PlayOffTeam(getSortedGroups("B").get(0).getTeamName()));
                    last16.add(new PlayOffTeam(getSortedGroups("A").get(1).getTeamName()));
                    break;
                case 5:
                    playOffListInfoModel[0].add(j, getSortedGroups("D").get(0).getTeamName() + " -:- " + getSortedGroups("C").get(1).getTeamName());
                    playOffListInfoModel[0].add(j + 1, " ");
                    jLabelPlayOff11.setIcon(new javax.swing.ImageIcon(getClass().getResource(getSortedGroups("D").get(0).getIconPath())));
                    jLabelPlayOff12.setIcon(new javax.swing.ImageIcon(getClass().getResource(getSortedGroups("C").get(1).getIconPath())));
                    last16.add(new PlayOffTeam(getSortedGroups("D").get(0).getTeamName()));
                    last16.add(new PlayOffTeam(getSortedGroups("C").get(1).getTeamName()));
                    break;
                case 6:
                    playOffListInfoModel[0].add(j, getSortedGroups("F").get(0).getTeamName() + " -:- " + getSortedGroups("E").get(1).getTeamName());
                    playOffListInfoModel[0].add(j + 1, " ");
                    jLabelPlayOff13.setIcon(new javax.swing.ImageIcon(getClass().getResource(getSortedGroups("F").get(0).getIconPath())));
                    jLabelPlayOff14.setIcon(new javax.swing.ImageIcon(getClass().getResource(getSortedGroups("E").get(1).getIconPath())));
                    last16.add(new PlayOffTeam(getSortedGroups("F").get(0).getTeamName()));
                    last16.add(new PlayOffTeam(getSortedGroups("E").get(1).getTeamName()));
                    break;
                case 7:
                    playOffListInfoModel[0].add(j, getSortedGroups("H").get(0).getTeamName() + " -:- " + getSortedGroups("G").get(1).getTeamName());
                    jLabelPlayOff15.setIcon(new javax.swing.ImageIcon(getClass().getResource(getSortedGroups("H").get(0).getIconPath())));
                    jLabelPlayOff16.setIcon(new javax.swing.ImageIcon(getClass().getResource(getSortedGroups("G").get(1).getIconPath())));
                    last16.add(new PlayOffTeam(getSortedGroups("H").get(0).getTeamName()));
                    last16.add(new PlayOffTeam(getSortedGroups("G").get(1).getTeamName()));
                    break;
            }
        }
    }
    
    public void fillLast8 () {
        if(last8.isEmpty()){
            fillPlayOffDefault(playOffListInfoModel[1], 7);
            return;
        }
        for(int i=0; i<last8.size(); i+=2) {
            switch(i){
                case 0:
                    playOffListInfoModel[1].add(i, last8.get(i).getTeamName() + " -:- " + last8.get(i + 1).getTeamName());
                    playOffListInfoModel[1].add(i + 1, " ");
                    jLabelPlayOff17.setIcon(new javax.swing.ImageIcon(getClass().getResource(last8.get(i).getIconPath())));
                    jLabelPlayOff18.setIcon(new javax.swing.ImageIcon(getClass().getResource(last8.get(i + 1).getIconPath())));
                    break;
                case 2:
                    playOffListInfoModel[1].add(i, last8.get(i).getTeamName() + " -:- " + last8.get(i + 1).getTeamName());
                    playOffListInfoModel[1].add(i + 1, " ");
                    jLabelPlayOff19.setIcon(new javax.swing.ImageIcon(getClass().getResource(last8.get(i).getIconPath())));
                    jLabelPlayOff20.setIcon(new javax.swing.ImageIcon(getClass().getResource(last8.get(i + 1).getIconPath())));
                    break;
                case 4:
                    playOffListInfoModel[1].add(i, last8.get(i).getTeamName() + " -:- " + last8.get(i + 1).getTeamName());
                    playOffListInfoModel[1].add(i + 1, " ");
                    jLabelPlayOff21.setIcon(new javax.swing.ImageIcon(getClass().getResource(last8.get(i).getIconPath())));
                    jLabelPlayOff22.setIcon(new javax.swing.ImageIcon(getClass().getResource(last8.get(i + 1).getIconPath())));
                    break;
                case 6:
                    playOffListInfoModel[1].add(i, last8.get(i).getTeamName() + " -:- " + last8.get(i + 1).getTeamName());
                    jLabelPlayOff23.setIcon(new javax.swing.ImageIcon(getClass().getResource(last8.get(i).getIconPath())));
                    jLabelPlayOff24.setIcon(new javax.swing.ImageIcon(getClass().getResource(last8.get(i + 1).getIconPath())));
                    break;
            } 
        }
        
    }
    
    public void fillLast4 () {
        if(last4.isEmpty()){
            fillPlayOffDefault(playOffListInfoModel[2], 3);
            return;
        }
        for(int i=0; i<last4.size(); i+=2) {
            switch(i){
                case 0:
                    playOffListInfoModel[2].add(i, last4.get(i).getTeamName() + " -:- " + last4.get(i + 1).getTeamName());
                    playOffListInfoModel[2].add(i + 1, " ");
                    jLabelPlayOff25.setIcon(new javax.swing.ImageIcon(getClass().getResource(last4.get(i).getIconPath())));
                    jLabelPlayOff26.setIcon(new javax.swing.ImageIcon(getClass().getResource(last4.get(i + 1).getIconPath())));
                    break;
                case 2:
                    playOffListInfoModel[2].add(i, last4.get(i).getTeamName() + " -:- " + last4.get(i + 1).getTeamName());
                    jLabelPlayOff27.setIcon(new javax.swing.ImageIcon(getClass().getResource(last4.get(i).getIconPath())));
                    jLabelPlayOff28.setIcon(new javax.swing.ImageIcon(getClass().getResource(last4.get(i + 1).getIconPath())));
                    break;
            } 
        }
    }
    
    public void fillLast2Third () {
        if(last2third.isEmpty()){
            fillPlayOffDefault(playOffListInfoModel[4], 1);
            return;
        }
        if(last2third.get(0).getIsWinner().equals("true") || last2third.get(1).getIsWinner().equals("true"))
            return;
        else {
            playOffListInfoModel[4].clear();
            for(int i=0; i<last2third.size(); i+=3) { 
                playOffListInfoModel[4].add(i, last2third.get(i).getTeamName() + " -:- " + last2third.get(i + 1).getTeamName());
                jLabelPlayOff31.setIcon(new javax.swing.ImageIcon(getClass().getResource(last2third.get(i).getIconPath())));
                jLabelPlayOff32.setIcon(new javax.swing.ImageIcon(getClass().getResource(last2third.get(i + 1).getIconPath())));  
            }
        }
    }
    
    public void fillLast2 () {
        if(last2.isEmpty()){
            fillPlayOffDefault(playOffListInfoModel[3], 1);
            return;
        }
        if(last2.get(0).getIsWinner().equals("true"))
            jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource(last2.get(0).getlargeIconPath())));
        else if(last2.get(1).getIsWinner().equals("true"))
            jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource(last2.get(1).getlargeIconPath())));
        else {
            playOffListInfoModel[3].clear();
            for(int i=0; i<last2.size(); i+=2) { 
                playOffListInfoModel[3].add(i, last2.get(i).getTeamName() + " -:- " + last2.get(i + 1).getTeamName());
                jLabelPlayOff29.setIcon(new javax.swing.ImageIcon(getClass().getResource(last2.get(i).getIconPath())));
                jLabelPlayOff30.setIcon(new javax.swing.ImageIcon(getClass().getResource(last2.get(i + 1).getIconPath())));  
            }
        }
    }
    
    public void processMatchResult(ArrayList<GroupTeam> group, DefaultTableModel tableInfoModel, DefaultListModel listInfoModel, JList jList , String matchResult, String groupName) {
        int listIndex = jList.getSelectedIndex();
        if (listIndex == -1 || jList.getSelectedValue().equals(" "))
            JOptionPane.showMessageDialog(this, "Выберите матч", "Ошибка", JOptionPane.WARNING_MESSAGE);
        else if (matchResult.length() < 3) 
            JOptionPane.showMessageDialog(this, "\nВведите результат матча в формате H:A\nH - голы, забитые первой командой,\nA - голы, забитые второй командой", "Ошибка", JOptionPane.WARNING_MESSAGE);
        else {
            try {
                String match = (String)jList.getSelectedValue();
                String homeTeamName = match.split(" ")[0];
                String result = match.split(" ")[1];
                String guestTeamName = match.split(" ")[2];
                
                int homeGoals = Integer.parseInt(matchResult.split(":")[0]);
                int awayGoals = Integer.parseInt(matchResult.split(":")[1]);
                int lastHomeGoals;
                int lastAwayGoals;
                if(homeGoals < 0 || awayGoals < 0 || homeGoals > 99 || awayGoals > 99) {
                    JOptionPane.showMessageDialog(this, "Введите корректные данные", "Ошибка", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                for(int i=0; i<group.size(); i++) {
                    if(group.get(i).getTeamName().equals(homeTeamName)){
                        group.get(i).processMatch(homeGoals, awayGoals, guestTeamName);
                        if(result.equals("-:-")){
                            teams.get( findTeam(homeTeamName) ).processMatch(homeGoals, awayGoals, guestTeamName);
                        }
                        else {
                            lastHomeGoals = Integer.parseInt(result.split(":")[0]);
                            lastAwayGoals = Integer.parseInt(result.split(":")[1]);
                            teams.get( findTeam(homeTeamName) ).removeLastMatch(lastHomeGoals, lastAwayGoals);
                            teams.get( findTeam(homeTeamName) ).processMatch(homeGoals, awayGoals, guestTeamName);
                        }
                    }
                    else if(group.get(i).getTeamName().equals(guestTeamName)){
                        group.get(i).processMatch(awayGoals, homeGoals, homeTeamName);
                        if(result.equals("-:-")){
                            teams.get( findTeam(guestTeamName) ).processMatch(awayGoals, homeGoals, guestTeamName);
                        }
                        else {
                            lastHomeGoals = Integer.parseInt(result.split(":")[0]);
                            lastAwayGoals = Integer.parseInt(result.split(":")[1]);
                            teams.get( findTeam(guestTeamName) ).removeLastMatch(lastAwayGoals, lastHomeGoals);
                            teams.get( findTeam(guestTeamName) ).processMatch(awayGoals, homeGoals, guestTeamName);
                        }
                    }
                }
                
                fillTable(tableInfoModel, groupName);
                
                result = Integer.toString(homeGoals) + ":" + Integer.toString(awayGoals);
                listInfoModel.setElementAt((homeTeamName + " " + result + " " + guestTeamName), listIndex);
                
                if(isGroupsFinished()){
                    fillLast16();
                }
                updateStatistic("clear");
            }
            catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, e.getMessage() + "\nВведите результаты матча в формате H:A\nH - голы, забитые первой командой,\nA - голы, забитые второй командой", "Ошибка", JOptionPane.WARNING_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage() + "\nВведите результаты матча в формате H:A\nH - голы, забитые первой командой,\nA - голы, забитые второй командой", "Ошибка", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    
    public void processPlayOffResult(ArrayList<PlayOffTeam> last, DefaultListModel listInfoModel, JList jList , String matchResult) {
        int listIndex = jList.getSelectedIndex();
        if (listIndex == -1 || jList.getSelectedValue().equals(" "))
            JOptionPane.showMessageDialog(this, "Выберите матч", "Ошибка", JOptionPane.WARNING_MESSAGE);
        else if (matchResult.length() < 3) 
            JOptionPane.showMessageDialog(this, "\nВведите результат матча в формате H:A\nH - голы, забитые первой командой,\nA - голы, забитые второй командой", "Ошибка", JOptionPane.WARNING_MESSAGE);
        else {
            try {
                String match = (String)jList.getSelectedValue();
                String homeTeamName = match.split(" ")[0];
                String result = match.split(" ")[1];
                String guestTeamName = match.split(" ")[2];
                
                int homeGoals = Integer.parseInt(matchResult.split(":")[0]);
                int awayGoals = Integer.parseInt(matchResult.split(":")[1]);
                int lastHomeGoals;
                int lastAwayGoals;
                if(homeGoals < 0 || awayGoals < 0 || homeGoals > 99 || awayGoals > 99) {
                    JOptionPane.showMessageDialog(this, "Введите корректные данные", "Ошибка", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                if(homeGoals != awayGoals) {
                    last.get(listIndex).processMatch(homeGoals, awayGoals, "");
                    if(result.equals("-:-")) {
                        teams.get( findTeam(homeTeamName) ).processMatch(homeGoals, awayGoals, guestTeamName);
                    }
                    else {
                        if(result.contains("(")){
                            String draw = result.substring(0, 3);
                            lastHomeGoals = Integer.parseInt(draw.split(":")[0]);
                            lastAwayGoals = Integer.parseInt(draw.split(":")[1]);
                            teams.get( findTeam(homeTeamName) ).removeLastMatch(lastHomeGoals, lastAwayGoals);
                            teams.get( findTeam(homeTeamName) ).processMatch(homeGoals, awayGoals, guestTeamName);
                        }
                        else{
                            lastHomeGoals = Integer.parseInt(result.split(":")[0]);
                            lastAwayGoals = Integer.parseInt(result.split(":")[1]);
                            teams.get( findTeam(homeTeamName) ).removeLastMatch(lastHomeGoals, lastAwayGoals);
                            teams.get( findTeam(homeTeamName) ).processMatch(homeGoals, awayGoals, guestTeamName);
                        }
                    }
                    
                    last.get(listIndex + 1).processMatch(awayGoals, homeGoals, "");
                    if(result.equals("-:-")) {
                        teams.get( findTeam(guestTeamName) ).processMatch(awayGoals, homeGoals, homeTeamName);
                    }
                    else {
                        if(result.contains("(")){
                            String draw = result.substring(0, 3);
                            lastHomeGoals = Integer.parseInt(draw.split(":")[0]);
                            lastAwayGoals = Integer.parseInt(draw.split(":")[1]);
                            teams.get( findTeam(guestTeamName) ).removeLastMatch(lastAwayGoals, lastHomeGoals);
                            teams.get( findTeam(guestTeamName) ).processMatch(awayGoals, homeGoals, homeTeamName);
                        }
                        else{
                            lastHomeGoals = Integer.parseInt(result.split(":")[0]);
                            lastAwayGoals = Integer.parseInt(result.split(":")[1]);
                            teams.get( findTeam(guestTeamName) ).removeLastMatch(lastAwayGoals, lastHomeGoals);
                            teams.get( findTeam(guestTeamName) ).processMatch(awayGoals, homeGoals, homeTeamName);
                        }
                    }
                    
                    listInfoModel.setElementAt(homeTeamName + " " + last.get(listIndex).getLastScoreWithContender().replace(';', ':') + " " + guestTeamName, listIndex);
                }
                else {
                    if(result.equals("-:-")){
                        teams.get( findTeam(homeTeamName) ).processMatch(homeGoals, awayGoals, guestTeamName);
                    }
                    else {
                        if(result.contains("(")){
                            String draw = result.substring(0, 3);
                            lastHomeGoals = Integer.parseInt(draw.split(":")[0]);
                            lastAwayGoals = Integer.parseInt(draw.split(":")[1]);
                            teams.get( findTeam(homeTeamName) ).removeLastMatch(lastHomeGoals, lastAwayGoals);
                            teams.get( findTeam(homeTeamName) ).processMatch(homeGoals, awayGoals, guestTeamName);
                        }
                        else{
                            lastHomeGoals = Integer.parseInt(result.split(":")[0]);
                            lastAwayGoals = Integer.parseInt(result.split(":")[1]);
                            teams.get( findTeam(homeTeamName) ).removeLastMatch(lastHomeGoals, lastAwayGoals);
                            teams.get( findTeam(homeTeamName) ).processMatch(homeGoals, awayGoals, guestTeamName);
                        }
                    }
                    
                    if(result.equals("-:-")){
                        teams.get( findTeam(guestTeamName) ).processMatch(awayGoals, homeGoals, guestTeamName);
                    }
                    else {
                        if(result.contains("(")){
                            String draw = result.substring(0, 3);
                            lastHomeGoals = Integer.parseInt(draw.split(":")[0]);
                            lastAwayGoals = Integer.parseInt(draw.split(":")[1]);
                            teams.get( findTeam(guestTeamName) ).removeLastMatch(lastAwayGoals, lastHomeGoals);
                            teams.get( findTeam(guestTeamName) ).processMatch(awayGoals, homeGoals, homeTeamName);
                        }
                        else{
                            lastHomeGoals = Integer.parseInt(result.split(":")[0]);
                            lastAwayGoals = Integer.parseInt(result.split(":")[1]);
                            teams.get( findTeam(guestTeamName) ).removeLastMatch(lastAwayGoals, lastHomeGoals);
                            teams.get( findTeam(guestTeamName) ).processMatch(awayGoals, homeGoals, guestTeamName);
                        }
                    }
                    
                    processPenalty(last, homeGoals, awayGoals, listIndex, listInfoModel);
                }
                
                isLastFinished(last); 
            }
            catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "\nВведите результаты матча в формате H:A\nH - голы, забитые первой командой,\nA - голы, забитые второй командой", "Ошибка", JOptionPane.WARNING_MESSAGE);
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage() + "\nВведите результаты матча в формате H:A\nH - голы, забитые первой командой,\nA - голы, забитые второй командой", "Ошибка", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    
    public void processPenalty(ArrayList<PlayOffTeam> last, int homeGoals, int awayGoals, int listIndex, DefaultListModel listInfoModel) {
        boolean dialog = true;
        while(dialog) {
            String result = (String)JOptionPane.showInputDialog(this, "Введите результат серии пенальти в формате H:A", "Серия пенальти", JOptionPane.PLAIN_MESSAGE, null, null, null);
            result = result.trim();
            if (result.length() < 3) 
                JOptionPane.showMessageDialog(this, "\nВведите результат серии пенальти в формате H:A\nH - голы, забитые первой командой,\nA - голы, забитые второй командой", "Ошибка", JOptionPane.WARNING_MESSAGE);
            else {
                try {
                    int homeGoalsPenalty = Integer.parseInt(result.split(":")[0]);
                    int awayGoalsPenalty = Integer.parseInt(result.split(":")[1]);
                    if(homeGoalsPenalty < 0 || awayGoalsPenalty < 0 || homeGoalsPenalty > 99 || awayGoalsPenalty > 99 || (homeGoalsPenalty == awayGoalsPenalty))
                        JOptionPane.showMessageDialog(this, "Введите корректные данные", "Ошибка", JOptionPane.WARNING_MESSAGE);
                    else {
                        last.get(listIndex).processPenalty(homeGoals, awayGoals, homeGoalsPenalty, awayGoalsPenalty);
                        last.get(listIndex + 1).processPenalty(homeGoals, awayGoals, awayGoalsPenalty, homeGoalsPenalty);
                        listInfoModel.setElementAt( last.get(listIndex).getTeamName() + " " + 
                                last.get(listIndex).getLastScoreWithContender().replace(';', ':') + "("
                                + last.get(listIndex).getLastPenaltyWithContender().replace(';', ':') + ") " 
                                + last.get(listIndex + 1).getTeamName(), listIndex);
                        dialog = false; 
                    }
                }
                catch (NumberFormatException ne) {
                    JOptionPane.showMessageDialog(this, ne.getMessage() + "\nВведите результаты серии пенальти в формате H:A\nH - голы, забитые первой командой,\nA - голы, забитые второй командой", "Ошибка", JOptionPane.WARNING_MESSAGE);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, e.getMessage() + "\nВведите результаты серии пенальти в формате H:A\nH - голы, забитые первой командой,\nA - голы, забитые второй командой", "Ошибка", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }
    
    public int findTeam(String teamName) {
        int pos = 0;
        for(int i=0; i<teams.size(); i++)
            if(teams.get(i).getTeamName().equals(teamName)){
                pos = i;
                break;
            }
        return pos;
    }
    
    public boolean isGroupsFinished () {
        GroupTeam temp;
        for(int i = 0; i<groups.length; i++) {
            for(int j = 0; j<4; j++) {
                temp = (GroupTeam)groups[i].get(j);
                if(temp.getMatchesPlayed() != 3)
                    return false;
            }
        }
        return true;
    }
    
    public void isLastFinished(ArrayList<PlayOffTeam> last) {
        updateStatistic("clear");
        int size = last.size();
        if(size == 16) {
            if(isRoundFinished(last16)) {
                last8.clear();
                last4.clear();
                last2third.clear();
                last2.clear();
                jLabel46.setIcon(null);
                fillLast8();
                fillLast4();
                fillLast2Third();
                fillLast2();
                for(int i=0; i<last16.size(); i++) {
                    if(last16.get(i).isWinner){
                        last8.add(new PlayOffTeam(last16.get(i).getTeamName()));
                    }
                }
                fillLast8();
                size = last8.size();
            }
        }
        if(size == 8) {
            if(isRoundFinished(last8)) {
                last4.clear();
                last2third.clear();
                last2.clear();
                jLabel46.setIcon(null);
                fillLast4();
                fillLast2Third();
                fillLast2();
                for(int i=0; i<last8.size(); i++){
                    if(last8.get(i).isWinner){
                        last4.add(new PlayOffTeam(last8.get(i).getTeamName()));
                    }
                }
                fillLast4();
                size = last4.size();
            }
        }
        if(size == 4) {
            if(isRoundFinished(last4)) {
                 last2third.clear();
                 last2.clear();
                 fillLast2Third();
                 fillLast2();
                 jLabel46.setIcon(null);
                 for(int i=0; i<last4.size(); i++){
                    if(!last4.get(i).isWinner){
                        last2third.add(new PlayOffTeam(last4.get(i).getTeamName()));
                    }
                 }
                 last2third.add(new PlayOffTeam("default"));
                 for(int i=0; i<last4.size(); i++){
                    if(last4.get(i).isWinner){
                        last2.add(new PlayOffTeam(last4.get(i).getTeamName()));
                    }
                 }
                 fillLast2Third();
                 fillLast2();
            }
        }
        if(size == 3) {
            if(isRoundFinished(last2third)) { 
                fillLast2Third();
            }
        }
        if(size == 2) {
            if(isRoundFinished(last2)) { 
                fillLast2();
                updateStatistic("update");
            }
        }
    }
    
    public boolean isRoundFinished (ArrayList<PlayOffTeam> last) {
        int count = 0;
        for(int i=0; i<last.size(); i++) {
            if(last.get(i).getIsWinner().equals("true"))
                count++;
        }
        if(count == last.size()/2)
            return true;
        else
            return false;
    }
    
    public ArrayList<GroupTeam> getSortedGroups(String group) {
        ArrayList<GroupTeam> copy = new ArrayList<GroupTeam>();
        
        switch(group){
            case "A":
                for (int i = 0; i < 4; i++) {
                    copy.add((GroupTeam)groups[0].get(i));
                }
                Collections.sort(copy, Collections.reverseOrder());
                break;
            case "B":
                for (int i = 0; i < 4; i++) {
                    copy.add((GroupTeam)groups[1].get(i));
                }
                Collections.sort(copy, Collections.reverseOrder());
                break;
            case "C":
                for (int i = 0; i < 4; i++) {
                    copy.add((GroupTeam)groups[2].get(i));
                }
                Collections.sort(copy, Collections.reverseOrder());
                break;
            case "D":
                for (int i = 0; i < 4; i++) {
                    copy.add((GroupTeam)groups[3].get(i));
                }
                Collections.sort(copy, Collections.reverseOrder());
                break;
            case "E":
                for (int i = 0; i < 4; i++) {
                    copy.add((GroupTeam)groups[4].get(i));
                }
                Collections.sort(copy, Collections.reverseOrder());
                break;
            case "F":
                for (int i = 0; i < 4; i++) {
                    copy.add((GroupTeam)groups[5].get(i));
                }
                Collections.sort(copy, Collections.reverseOrder());
                break;
            case "G":
                for (int i = 0; i < 4; i++) {
                    copy.add((GroupTeam)groups[6].get(i));
                }
                Collections.sort(copy, Collections.reverseOrder());
                break;
            case "H":
                for (int i = 0; i < 4; i++) {
                    copy.add((GroupTeam)groups[7].get(i));
                }
                Collections.sort(copy, Collections.reverseOrder());
                break;
        }
        return copy;
    }
    
    public void loadGroupRound(String filePath) {
        File file = new File(filePath);
        BufferedReader inputBuffer = null;
        Scanner inputScanner = null;
        String line = "";
        
        int groupNum = 0;
        int lineNum = 0;
        String teamName;
        String contender1;
        String contender2;
        String contender3;
        int played;
        int wins;
        int loses;
        int draws;
        int scored;
        int conceded;
        int points;
        boolean isPlayedWithContender1;
        boolean isPlayedWithContender2;
        boolean isPlayedWithContender3;
        int [] lastScoreWithContender1 = {0, 0};
        int [] lastScoreWithContender2 = {0, 0};
        int [] lastScoreWithContender3 = {0, 0};
        String lastResultWithContender1;
        String lastResultWithContender2;
        String lastResultWithContender3;
        
        if (file.exists()) {
            try {
                inputBuffer = new BufferedReader(new InputStreamReader(new FileInputStream(file), "Cp1251"));
                inputScanner = new Scanner(inputBuffer);
                
                while (inputScanner.hasNextLine()) {
                    line = inputScanner.nextLine();
                    lineNum++;
                    teamName = line.split(";")[0];
                    contender1 = line.split(";")[1];
                    contender2 = line.split(";")[2];
                    contender3 = line.split(";")[3];
                    played = Integer.parseInt(line.split(";")[4]);
                    wins = Integer.parseInt(line.split(";")[5]);
                    loses = Integer.parseInt(line.split(";")[6]);
                    draws = Integer.parseInt(line.split(";")[7]);
                    scored = Integer.parseInt(line.split(";")[8]);
                    conceded = Integer.parseInt(line.split(";")[9]);
                    points = Integer.parseInt(line.split(";")[10]);
                    isPlayedWithContender1 = Boolean.parseBoolean(line.split(";")[11]);
                    isPlayedWithContender2 = Boolean.parseBoolean(line.split(";")[12]);
                    isPlayedWithContender3 = Boolean.parseBoolean(line.split(";")[13]);
                    lastScoreWithContender1[0] = Integer.parseInt(line.split(";")[14]);
                    lastScoreWithContender1[1] = Integer.parseInt(line.split(";")[15]); 
                    lastScoreWithContender2[0] = Integer.parseInt(line.split(";")[16]);
                    lastScoreWithContender2[1] = Integer.parseInt(line.split(";")[17]);
                    lastScoreWithContender3[0] = Integer.parseInt(line.split(";")[18]);
                    lastScoreWithContender3[1] = Integer.parseInt(line.split(";")[19]);
                    lastResultWithContender1 = line.split(";")[20];
                    lastResultWithContender2 = line.split(";")[21];
                    lastResultWithContender3 = line.split(";")[22];
                    
                    teams.add(new Team(teamName, played, wins, loses, draws, scored, conceded));
                    if(lineNum <= 4){
                        groups[groupNum].add( new GroupTeam(teamName, contender1, contender2, contender3, played,
                                wins, loses, draws, scored, conceded, points, isPlayedWithContender1, isPlayedWithContender2,
                                isPlayedWithContender3, lastScoreWithContender1, lastScoreWithContender2, lastScoreWithContender3,
                                lastResultWithContender1, lastResultWithContender2, lastResultWithContender3) );
                        
                        if(lineNum == 4){
                            lineNum = 0;
                            groupNum++;
                        }
                    }
                }
                
                inputScanner.close();
                inputBuffer.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Ошибка ввода/вывода", JOptionPane.WARNING_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Ошибка", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            loadDefault();
        }
    }
    
    public void loadPlayOffRound(String filePath, ArrayList<PlayOffTeam> last, String round) {
        File file = new File(filePath);
        BufferedReader inputBuffer = null;
        Scanner inputScanner = null;
        String line = "";
        
        String teamName;
        boolean isWinner; 
        boolean isPenalty;
        int [] lastScoreWithContender = {0, 0};
        int [] lastPenaltyWithContender = {0, 0};
        
        if (file.exists()) {
            try {
                inputBuffer = new BufferedReader(new InputStreamReader(new FileInputStream(file), "Cp1251"));
                inputScanner = new Scanner(inputBuffer);

                int i = 0;
                while (inputScanner.hasNextLine()) {
                    line = inputScanner.nextLine();
                    teamName = line.split(";")[0];
                    isWinner = Boolean.parseBoolean(line.split(";")[1]);
                    isPenalty = Boolean.parseBoolean(line.split(";")[2]);
                    lastScoreWithContender[0] = Integer.parseInt(line.split(";")[3]);
                    lastScoreWithContender[1] = Integer.parseInt(line.split(";")[4]);
                    lastPenaltyWithContender[0] = Integer.parseInt(line.split(";")[5]);
                    lastPenaltyWithContender[1] = Integer.parseInt(line.split(";")[6]);
                    
                    last.add(new PlayOffTeam(teamName, isWinner, isPenalty, lastScoreWithContender, lastPenaltyWithContender));
                    if(!(lastScoreWithContender[0] == -1)){
                        int pos = findTeam(last.get(i).getTeamName());
                        teams.get(pos).processMatch(lastScoreWithContender[0], lastScoreWithContender[1], "");
                    }
                    i++;
                }
                
                if(i != 0){
                    switch(round) {
                        case "last16":
                            fillPlayOffAfterLoad(last16, playOffListInfoModel[0]);
                            break;
                        case "last8":
                            fillPlayOffAfterLoad(last8, playOffListInfoModel[1]);
                            break;
                        case "last4":
                            fillPlayOffAfterLoad(last4, playOffListInfoModel[2]);
                            break;
                        case "last2third":
                            fillPlayOffAfterLoad(last2third, playOffListInfoModel[4]);
                            break;
                        case "last2":
                            fillPlayOffAfterLoad(last2, playOffListInfoModel[3]);
                            break;
                    }
                }
                else {
                    switch(round) {
                        case "last16":
                            fillLast16();
                            break;
                        case "last8":
                            fillLast8();
                            break;
                        case "last4":
                            fillLast4();
                            break;
                        case "last2third":
                            fillLast2Third();
                            break;
                        case "last2":
                            fillLast2();
                            break;
                    }
                }   
                
                inputScanner.close();
                inputBuffer.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Ошибка ввода/вывода", JOptionPane.WARNING_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Ошибка", JOptionPane.WARNING_MESSAGE);
            }
            
        } else {
            switch(round) {
                case "last16":
                    fillLast16();
                    break;
                case "last8":
                    fillLast8();
                    break;
                case "last4":
                    fillLast4();
                    break;
                case "last2":
                    fillLast2();
                    break;
            }
        }
    }
    
    public void loadDefault() {
        String [] teamNames = { "Бразилия", "Хорватия", "Мексика", "Камерун", "Испания", "Нидерланды", "Чили",
        "Австралия", "Колумбия", "Греция", "Кот-д'Ивуар", "Япония", "Уругвай", "Коста-Рика", "Англия", "Италия",
        "Швейцария", "Эквадор", "Франция", "Гондурас", "Аргентина", "Босния", "Иран", "Нигерия",
        "Германия", "Португалия", "Гана", "США", "Бельгия", "Алжир", "Россия", "Ю.Корея" };
        
        for(int i=0; i<32; i++){
            teams.add(new Team(teamNames[i])); 
            if(i<4)
                groups[0].add(new GroupTeam(teamNames[i]));
            else if(i>=4 && i<8)
                groups[1].add(new GroupTeam(teamNames[i]));
            else if(i>=8 && i<12)
                groups[2].add(new GroupTeam(teamNames[i]));
            else if(i>=12 && i<16)
                groups[3].add(new GroupTeam(teamNames[i]));
            else if(i>=16 && i<20)
                groups[4].add(new GroupTeam(teamNames[i]));
            else if(i>=20 && i<24)
                groups[5].add(new GroupTeam(teamNames[i]));
            else if(i>=24 && i<28)
                groups[6].add(new GroupTeam(teamNames[i]));
            else if(i>=28 && i<32)
                groups[7].add(new GroupTeam(teamNames[i]));              
        }
    }
    
    public void saveFile(String filePath) {
        File file = null;
        FileWriter outputStream = null;
        BufferedWriter outputBuffer = null;
        PrintWriter outputPrinter = null;
        
        int groupNum = 0;
        int teamNum = 0;
        String team;
        String contender1;
        String contender2;
        String contender3;
        int played;
        int wins;
        int loses;
        int draws;
        int scored;
        int conceded;
        int points;
        String isPlayedWithContender1;
        String isPlayedWithContender2;
        String isPlayedWithContender3;
        String lastScoreWithContender1;
        String lastScoreWithContender2;
        String lastScoreWithContender3;
        String lastResultWithContender1;
        String lastResultWithContender2;
        String lastResultWithContender3;
        
        try {
            file = new File(filePath);
            outputStream = new FileWriter(file, false);
            outputBuffer = new BufferedWriter(outputStream);
            outputPrinter = new PrintWriter(outputBuffer);
            for (int i = 0; i < teams.size(); i++) {
                GroupTeam temp = (GroupTeam)groups[groupNum].get(teamNum);
                
                team = temp.getTeamName();
                contender1 = temp.getContenderName1();
                contender2 = temp.getContenderName2();
                contender3 = temp.getContenderName3();
                played = temp.getMatchesPlayed();
                wins = temp.getWins();
                loses = temp.getLoses();
                draws = temp.getDraws();
                scored = temp.getGoalsFor();
                conceded = temp.getGoalsAgainst();
                points = temp.getPoints();
                isPlayedWithContender1 = temp.getIsPlayedWithContender1();
                isPlayedWithContender2 = temp.getIsPlayedWithContender2();
                isPlayedWithContender3 = temp.getIsPlayedWithContender3();
                lastScoreWithContender1 = temp.getLastScoreWithContender1();
                lastScoreWithContender2 = temp.getLastScoreWithContender2();
                lastScoreWithContender3 = temp.getLastScoreWithContender3();
                lastResultWithContender1 = temp.getLastResultWithContender1();
                lastResultWithContender2 = temp.getLastResultWithContender2();
                lastResultWithContender3 = temp.getLastResultWithContender3();

                if (i > 0) {
                    outputPrinter.println();
                }
                outputPrinter.flush();
                outputPrinter.print( team + ";" + contender1 + ";" + contender2 + ";" + contender3 + ";"
                        + played + ";" + wins + ";" + loses + ";" + draws + ";" + scored + ";" + conceded + ";" 
                        + points + ";" + isPlayedWithContender1 + ";" + isPlayedWithContender2 + ";"
                        + isPlayedWithContender3 + ";" + lastScoreWithContender1 + ";" + lastScoreWithContender2 + ";"
                        + lastScoreWithContender3 + ";" + lastResultWithContender1 + ";" + lastResultWithContender2 + ";"
                        + lastResultWithContender3 );
                teamNum++;
                if(teamNum == 4)
                    teamNum = 0;
                if( (i+1) % 4 == 0 )
                    groupNum++;
            }
            outputPrinter.close();
            outputBuffer.close();
            outputStream.close();
            JOptionPane.showMessageDialog(this, "Результаты были успешно сохранены", "Информация", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Ошибка ввода/вывода", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Ошибка", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void savePlayOffRound(String filePath, ArrayList<PlayOffTeam> last) {
        File file = null;
        FileWriter outputStream = null;
        BufferedWriter outputBuffer = null;
        PrintWriter outputPrinter = null;
        
        String teamName;
        String isWinner;
        String isPenalty;
        String lastScoreWithContender;
        String lastPenaltyWithContender;
        
        try {
            file = new File(filePath);
            if(last.isEmpty()){
                if(file.exists()){
                    file.delete();
                    return;
                }
            }
            
            outputStream = new FileWriter(file, false);
            outputBuffer = new BufferedWriter(outputStream);
            outputPrinter = new PrintWriter(outputBuffer);
            for(int i=0; i<last.size(); i++) {
                PlayOffTeam temp = (PlayOffTeam)last.get(i);
                teamName = temp.getTeamName();
                isWinner = temp.getIsWinner();
                isPenalty = temp.getIsPenalty();
                lastScoreWithContender = temp.getLastScoreWithContender();
                lastPenaltyWithContender = temp.getLastPenaltyWithContender();
             
                if (i > 0) {
                    outputPrinter.println();
                }
            
                outputPrinter.flush();
                outputPrinter.print( teamName + ";" + isWinner + ";" + isPenalty + ";" + lastScoreWithContender
                    + ";" + lastPenaltyWithContender);
            }
            outputPrinter.close();
            outputBuffer.close();
            outputStream.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Ошибка ввода/вывода", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Ошибка", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    void setInfo() {
        String teamName = (String)jList13.getSelectedValue();
        jLabel63.setIcon(new javax.swing.ImageIcon(getClass().getResource(teams.get(findTeam(teamName)).getlargeIconPath())));
        String filePath = "Info/" + teamName + ".txt";
        File file = new File(filePath);
        BufferedReader inputBuffer = null;
        Scanner inputScanner = null;
        String line = "";
        jTextArea6.setText("");
        if (file.exists()) {
            try {
                inputBuffer = new BufferedReader(new InputStreamReader(new FileInputStream(file), "Cp1251"));
                inputScanner = new Scanner(inputBuffer);
                while (inputScanner.hasNextLine()) {
                    line = inputScanner.nextLine();
                    jTextArea6.append(line + "\n");
                }
                inputScanner.close();
                inputBuffer.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Ошибка ввода/вывода", JOptionPane.WARNING_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Ошибка", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Файл " + teamName + ".txt не был найден", "Ошибка", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        jLabel7 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList();
        jLabel11 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        jLabel73 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        jList4 = new javax.swing.JList();
        jLabel15 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        jLabel97 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        jList5 = new javax.swing.JList();
        jLabel19 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jPanel14 = new javax.swing.JPanel();
        jLabel121 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        jLabel129 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        jLabel137 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        jLabel141 = new javax.swing.JLabel();
        jLabel144 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        jList6 = new javax.swing.JList();
        jLabel23 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        jLabel145 = new javax.swing.JLabel();
        jLabel148 = new javax.swing.JLabel();
        jLabel149 = new javax.swing.JLabel();
        jLabel152 = new javax.swing.JLabel();
        jLabel153 = new javax.swing.JLabel();
        jLabel156 = new javax.swing.JLabel();
        jLabel157 = new javax.swing.JLabel();
        jLabel160 = new javax.swing.JLabel();
        jLabel161 = new javax.swing.JLabel();
        jLabel164 = new javax.swing.JLabel();
        jLabel165 = new javax.swing.JLabel();
        jLabel168 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        jList7 = new javax.swing.JList();
        jLabel27 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable8 = new javax.swing.JTable();
        jPanel16 = new javax.swing.JPanel();
        jLabel169 = new javax.swing.JLabel();
        jLabel172 = new javax.swing.JLabel();
        jLabel173 = new javax.swing.JLabel();
        jLabel176 = new javax.swing.JLabel();
        jLabel177 = new javax.swing.JLabel();
        jLabel180 = new javax.swing.JLabel();
        jLabel181 = new javax.swing.JLabel();
        jLabel184 = new javax.swing.JLabel();
        jLabel185 = new javax.swing.JLabel();
        jLabel188 = new javax.swing.JLabel();
        jLabel189 = new javax.swing.JLabel();
        jLabel192 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane16 = new javax.swing.JScrollPane();
        jList8 = new javax.swing.JList();
        jLabel31 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel18 = new javax.swing.JPanel();
        jScrollPane17 = new javax.swing.JScrollPane();
        jList9 = new javax.swing.JList();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jLabelPlayOff1 = new javax.swing.JLabel();
        jLabelPlayOff2 = new javax.swing.JLabel();
        jLabelPlayOff3 = new javax.swing.JLabel();
        jLabelPlayOff4 = new javax.swing.JLabel();
        jLabelPlayOff5 = new javax.swing.JLabel();
        jLabelPlayOff6 = new javax.swing.JLabel();
        jLabelPlayOff7 = new javax.swing.JLabel();
        jLabelPlayOff8 = new javax.swing.JLabel();
        jLabelPlayOff9 = new javax.swing.JLabel();
        jLabelPlayOff10 = new javax.swing.JLabel();
        jLabelPlayOff11 = new javax.swing.JLabel();
        jLabelPlayOff12 = new javax.swing.JLabel();
        jLabelPlayOff13 = new javax.swing.JLabel();
        jLabelPlayOff14 = new javax.swing.JLabel();
        jLabelPlayOff15 = new javax.swing.JLabel();
        jLabelPlayOff16 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabelPlayOff17 = new javax.swing.JLabel();
        jScrollPane19 = new javax.swing.JScrollPane();
        jList10 = new javax.swing.JList();
        jLabelPlayOff18 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jLabelPlayOff19 = new javax.swing.JLabel();
        jLabelPlayOff20 = new javax.swing.JLabel();
        jLabelPlayOff21 = new javax.swing.JLabel();
        jLabelPlayOff22 = new javax.swing.JLabel();
        jLabelPlayOff23 = new javax.swing.JLabel();
        jLabelPlayOff24 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabelPlayOff25 = new javax.swing.JLabel();
        jScrollPane21 = new javax.swing.JScrollPane();
        jList11 = new javax.swing.JList();
        jLabel50 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jLabelPlayOff26 = new javax.swing.JLabel();
        jLabelPlayOff27 = new javax.swing.JLabel();
        jLabelPlayOff28 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jLabel70 = new javax.swing.JLabel();
        jLabelPlayOff31 = new javax.swing.JLabel();
        jScrollPane30 = new javax.swing.JScrollPane();
        jList14 = new javax.swing.JList();
        jLabelPlayOff32 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jButton13 = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabelPlayOff29 = new javax.swing.JLabel();
        jScrollPane22 = new javax.swing.JScrollPane();
        jList12 = new javax.swing.JList();
        jLabelPlayOff30 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jButton12 = new javax.swing.JButton();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jScrollPane18 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabelStat1 = new javax.swing.JLabel();
        jLabelStat2 = new javax.swing.JLabel();
        jLabelStat3 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jScrollPane20 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabelStat4 = new javax.swing.JLabel();
        jLabelStat5 = new javax.swing.JLabel();
        jLabelStat6 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jScrollPane23 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jLabelStat7 = new javax.swing.JLabel();
        jLabelStat8 = new javax.swing.JLabel();
        jLabelStat9 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabelStat10 = new javax.swing.JLabel();
        jScrollPane24 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jLabelStat11 = new javax.swing.JLabel();
        jLabelStat12 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabelStat13 = new javax.swing.JLabel();
        jScrollPane25 = new javax.swing.JScrollPane();
        jTextArea5 = new javax.swing.JTextArea();
        jLabelStat14 = new javax.swing.JLabel();
        jLabelStat15 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabelStat16 = new javax.swing.JLabel();
        jScrollPane28 = new javax.swing.JScrollPane();
        jTextArea7 = new javax.swing.JTextArea();
        jLabelStat17 = new javax.swing.JLabel();
        jLabelStat18 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabelStat19 = new javax.swing.JLabel();
        jLabelStat20 = new javax.swing.JLabel();
        jScrollPane29 = new javax.swing.JScrollPane();
        jTextArea8 = new javax.swing.JTextArea();
        jLabelStat21 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jScrollPane26 = new javax.swing.JScrollPane();
        jList13 = new javax.swing.JList();
        jScrollPane27 = new javax.swing.JScrollPane();
        jTextArea6 = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Чемпионат мира 2014: таблицы, результаты и статистика");
        setBackground(new java.awt.Color(0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImage(Toolkit.getDefaultToolkit().getImage(WorldCup2014.class.getResource("/wc2014/resources/icon.png")));
        setResizable(false);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(480, 476));

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setModel(tableInfoModel[0]);
        jTable1.setToolTipText("");
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setDropMode(javax.swing.DropMode.INSERT);
        jTable1.setEnabled(false);
        jTable1.setOpaque(false);
        jTable1.setPreferredSize(null);
        jTable1.setRowHeight(23);
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.setUpdateSelectionOnSort(false);
        jTable1.setVerifyInputWhenFocusTarget(false);
        jScrollPane1.setViewportView(jTable1);

        jPanel9.setBackground(new java.awt.Color(255, 255, 204));
        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel9.setPreferredSize(new java.awt.Dimension(452, 327));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Бразилия.png"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Хорватия.png"))); // NOI18N
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Камерун.png"))); // NOI18N
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Мексика.png"))); // NOI18N
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Бразилия.png"))); // NOI18N
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Мексика.png"))); // NOI18N
        jLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Камерун.png"))); // NOI18N
        jLabel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Хорватия.png"))); // NOI18N
        jLabel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Камерун.png"))); // NOI18N
        jLabel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Бразилия.png"))); // NOI18N
        jLabel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Хорватия.png"))); // NOI18N
        jLabel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Мексика.png"))); // NOI18N
        jLabel24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jList1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jList1.setModel(listInfoModel[0]);
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.setPreferredSize(new java.awt.Dimension(166, 250));
        jScrollPane9.setViewportView(jList1);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Выберите матч");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Результат (H:A)");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Добавить");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addComponent(jLabel5))
                            .addComponent(jLabel21)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel12)
                            .addComponent(jLabel16)
                            .addComponent(jLabel24)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(24, 24, 24)
                                        .addComponent(jLabel9)
                                        .addGap(23, 23, 23)
                                        .addComponent(jLabel13))
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(24, 24, 24)
                                        .addComponent(jLabel12)
                                        .addGap(23, 23, 23)
                                        .addComponent(jLabel16))))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel20))
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel24))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel21))))
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        jTabbedPane1.addTab("Группа А", jPanel1);

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane2.setPreferredSize(new java.awt.Dimension(452, 115));

        jTable2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable2.setModel(tableInfoModel[1]);
        jTable2.setEnabled(false);
        jTable2.setPreferredSize(null);
        jTable2.setRowHeight(23);
        jTable2.setRowSelectionAllowed(false);
        jTable2.getTableHeader().setResizingAllowed(false);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable2);

        jPanel10.setBackground(new java.awt.Color(255, 255, 204));
        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel10.setPreferredSize(new java.awt.Dimension(452, 327));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Испания.png"))); // NOI18N
        jLabel25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Нидерланды.png"))); // NOI18N
        jLabel28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Австралия.png"))); // NOI18N
        jLabel29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Чили.png"))); // NOI18N
        jLabel32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Австралия.png"))); // NOI18N
        jLabel33.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Нидерланды.png"))); // NOI18N
        jLabel36.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Испания.png"))); // NOI18N
        jLabel37.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Чили.png"))); // NOI18N
        jLabel40.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Австралия.png"))); // NOI18N
        jLabel41.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Испания.png"))); // NOI18N
        jLabel44.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Нидерланды.png"))); // NOI18N
        jLabel45.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Чили.png"))); // NOI18N
        jLabel48.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Выберите матч");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jList2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jList2.setModel(listInfoModel[1]);
        jList2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList2.setPreferredSize(new java.awt.Dimension(206, 250));
        jScrollPane10.setViewportView(jList2);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Результат (H:A)");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Добавить");
        jButton2.addActionListener(this);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(213, 213, 213)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel48, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel44, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(213, 213, 213)
                                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(212, 212, 212)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel32)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel37)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel33)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel41)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel45))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel29)))
                        .addGap(20, 20, 20)
                        .addComponent(jLabel40)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel36)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel44)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel48)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Группа B", jPanel2);

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));

        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTable3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable3.setModel(tableInfoModel[2]);
        jTable3.setEnabled(false);
        jTable3.setRowHeight(23);
        jTable3.setRowSelectionAllowed(false);
        jTable3.getTableHeader().setResizingAllowed(false);
        jTable3.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTable3);

        jPanel11.setBackground(new java.awt.Color(255, 255, 204));
        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel11.setPreferredSize(new java.awt.Dimension(452, 327));

        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Колумбия.png"))); // NOI18N
        jLabel49.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Греция.png"))); // NOI18N
        jLabel52.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Япония.png"))); // NOI18N
        jLabel53.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Кот-д'Ивуар.png"))); // NOI18N
        jLabel56.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel57.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Колумбия.png"))); // NOI18N
        jLabel57.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Кот-д'Ивуар.png"))); // NOI18N
        jLabel60.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Япония.png"))); // NOI18N
        jLabel61.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Греция.png"))); // NOI18N
        jLabel64.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel65.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Япония.png"))); // NOI18N
        jLabel65.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Колумбия.png"))); // NOI18N
        jLabel68.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel69.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Греция.png"))); // NOI18N
        jLabel69.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel72.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Кот-д'Ивуар.png"))); // NOI18N
        jLabel72.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Выберите матч");
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jList3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jList3.setModel(listInfoModel[2]);
        jList3.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList3.setPreferredSize(new java.awt.Dimension(166, 250));
        jScrollPane11.setViewportView(jList3);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Результат (H:A)");
        jLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setText("Добавить");
        jButton3.addActionListener(this);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel72, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel68, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel64, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel52, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3))))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel49)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel56)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel57)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel61)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel65)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel69))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel52)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel53))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20)
                        .addComponent(jLabel60)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel64)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel68)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel72)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Группа C", jPanel3);

        jPanel4.setBackground(new java.awt.Color(204, 255, 204));

        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTable4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable4.setModel(tableInfoModel[3]);
        jTable4.setEnabled(false);
        jTable4.setRowHeight(23);
        jTable4.setRowSelectionAllowed(false);
        jTable4.getTableHeader().setResizingAllowed(false);
        jTable4.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(jTable4);

        jPanel12.setBackground(new java.awt.Color(255, 255, 204));
        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel73.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Уругвай.png"))); // NOI18N
        jLabel73.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel76.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Коста-Рика.png"))); // NOI18N
        jLabel76.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel77.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Италия.png"))); // NOI18N
        jLabel77.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel80.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Англия.png"))); // NOI18N
        jLabel80.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel81.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Уругвай.png"))); // NOI18N
        jLabel81.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel84.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Англия.png"))); // NOI18N
        jLabel84.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel85.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Италия.png"))); // NOI18N
        jLabel85.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel88.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Коста-Рика.png"))); // NOI18N
        jLabel88.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel89.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Коста-Рика.png"))); // NOI18N
        jLabel89.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel92.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Англия.png"))); // NOI18N
        jLabel92.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel93.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Италия.png"))); // NOI18N
        jLabel93.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel96.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Уругвай.png"))); // NOI18N
        jLabel96.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Выберите матч");
        jLabel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jList4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jList4.setModel(listInfoModel[3]);
        jList4.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList4.setPreferredSize(new java.awt.Dimension(166, 250));
        jScrollPane12.setViewportView(jList4);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Результат (H:A)");
        jLabel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setText("Добавить");
        jButton4.addActionListener(this);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton4)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel96, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel73)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel80))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20)
                        .addComponent(jLabel81)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel85)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel93)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel89))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel76)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel77)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel84)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel88)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel96)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel92)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Группа D", jPanel4);

        jPanel5.setBackground(new java.awt.Color(204, 255, 204));

        jScrollPane5.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTable5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable5.setModel(tableInfoModel[4]);
        jTable5.setEnabled(false);
        jTable5.setRowHeight(23);
        jTable5.setRowSelectionAllowed(false);
        jTable5.getTableHeader().setResizingAllowed(false);
        jTable5.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(jTable5);

        jPanel13.setBackground(new java.awt.Color(255, 255, 204));
        jPanel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel97.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Швейцария.png"))); // NOI18N
        jLabel97.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel100.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Эквадор.png"))); // NOI18N
        jLabel100.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel101.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Гондурас.png"))); // NOI18N
        jLabel101.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel104.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Франция.png"))); // NOI18N
        jLabel104.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel105.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Швейцария.png"))); // NOI18N
        jLabel105.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel108.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Франция.png"))); // NOI18N
        jLabel108.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel109.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Гондурас.png"))); // NOI18N
        jLabel109.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel112.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Эквадор.png"))); // NOI18N
        jLabel112.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel113.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Гондурас.png"))); // NOI18N
        jLabel113.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel116.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Швейцария.png"))); // NOI18N
        jLabel116.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel117.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Эквадор.png"))); // NOI18N
        jLabel117.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel120.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Франция.png"))); // NOI18N
        jLabel120.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Выберите матч");
        jLabel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jList5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jList5.setModel(listInfoModel[4]);
        jList5.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList5.setPreferredSize(new java.awt.Dimension(166, 250));
        jScrollPane13.setViewportView(jList5);

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Результат (H:A)");
        jLabel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton5.setText("Добавить");
        jButton5.addActionListener(this);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel117, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel113, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel109, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel105, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel97, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel104, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(5, 5, 5)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel120, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel116, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel112, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel108, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel101, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel100, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel97)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel104)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel105)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel109)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel113)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel117))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel100)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel101))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20)
                        .addComponent(jLabel108)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel112)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel116)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel120)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Группа E", jPanel5);

        jPanel6.setBackground(new java.awt.Color(204, 255, 204));

        jScrollPane6.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTable6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable6.setModel(tableInfoModel[5]);
        jTable6.setEnabled(false);
        jTable6.setRowHeight(23);
        jTable6.setRowSelectionAllowed(false);
        jTable6.getTableHeader().setResizingAllowed(false);
        jTable6.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(jTable6);

        jPanel14.setBackground(new java.awt.Color(255, 255, 204));
        jPanel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel121.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Аргентина.png"))); // NOI18N
        jLabel121.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel124.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Босния.png"))); // NOI18N
        jLabel124.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel125.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Нигерия.png"))); // NOI18N
        jLabel125.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel128.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Иран.png"))); // NOI18N
        jLabel128.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel129.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Аргентина.png"))); // NOI18N
        jLabel129.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel132.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Иран.png"))); // NOI18N
        jLabel132.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel133.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Нигерия.png"))); // NOI18N
        jLabel133.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel136.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Босния.png"))); // NOI18N
        jLabel136.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel137.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Нигерия.png"))); // NOI18N
        jLabel137.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel140.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Аргентина.png"))); // NOI18N
        jLabel140.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel141.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Босния.png"))); // NOI18N
        jLabel141.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel144.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Иран.png"))); // NOI18N
        jLabel144.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Выберите матч");
        jLabel22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jList6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jList6.setModel(listInfoModel[5]);
        jList6.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList6.setPreferredSize(new java.awt.Dimension(166, 250));
        jScrollPane14.setViewportView(jList6);

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Результат (H:A)");
        jLabel23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton6.setText("Добавить");
        jButton6.addActionListener(this);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel141, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel137, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel133, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel128)
                            .addComponent(jLabel121, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel129))
                        .addGap(5, 5, 5)
                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel132, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel144, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel140, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel136, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel124, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel125, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton6)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel121)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel128))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel124)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel125)))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel132)
                            .addComponent(jLabel129))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel133)
                            .addComponent(jLabel136))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel137)
                            .addComponent(jLabel140))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel144)
                            .addComponent(jLabel141))))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane6)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Группа F", jPanel6);

        jPanel7.setBackground(new java.awt.Color(204, 255, 204));

        jScrollPane7.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTable7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable7.setModel(tableInfoModel[6]);
        jTable7.setEnabled(false);
        jTable7.setRowHeight(23);
        jTable7.setRowSelectionAllowed(false);
        jTable7.getTableHeader().setResizingAllowed(false);
        jTable7.getTableHeader().setReorderingAllowed(false);
        jScrollPane7.setViewportView(jTable7);

        jPanel15.setBackground(new java.awt.Color(255, 255, 204));
        jPanel15.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel145.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Германия.png"))); // NOI18N
        jLabel145.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel148.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Португалия.png"))); // NOI18N
        jLabel148.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel149.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/США.png"))); // NOI18N
        jLabel149.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel152.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Гана.png"))); // NOI18N
        jLabel152.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel153.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Германия.png"))); // NOI18N
        jLabel153.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel156.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Гана.png"))); // NOI18N
        jLabel156.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel157.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/США.png"))); // NOI18N
        jLabel157.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel160.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Португалия.png"))); // NOI18N
        jLabel160.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel161.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Португалия.png"))); // NOI18N
        jLabel161.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel164.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Гана.png"))); // NOI18N
        jLabel164.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel165.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/США.png"))); // NOI18N
        jLabel165.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel168.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Германия.png"))); // NOI18N
        jLabel168.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Выберите матч");
        jLabel26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jList7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jList7.setModel(listInfoModel[6]);
        jList7.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList7.setPreferredSize(new java.awt.Dimension(166, 250));
        jScrollPane15.setViewportView(jList7);

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Результат (H:A)");
        jLabel27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextField7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextField7.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton7.setText("Добавить");
        jButton7.addActionListener(this);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel161, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel157, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel153, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel152, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel145, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel165, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(5, 5, 5)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel160, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel156, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel148, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel149, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton7))
                            .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel168, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel164, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel145)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel152)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel153)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel157)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel165)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel161))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel148)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel149))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20)
                        .addComponent(jLabel156)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel160)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel168)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel164)))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane7)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        jTabbedPane1.addTab("Группа G", jPanel7);

        jPanel8.setBackground(new java.awt.Color(204, 255, 204));

        jScrollPane8.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTable8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable8.setModel(tableInfoModel[7]);
        jTable8.setEnabled(false);
        jTable8.setRowHeight(23);
        jTable8.setRowSelectionAllowed(false);
        jTable8.getTableHeader().setResizingAllowed(false);
        jTable8.getTableHeader().setReorderingAllowed(false);
        jScrollPane8.setViewportView(jTable8);

        jPanel16.setBackground(new java.awt.Color(255, 255, 204));
        jPanel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel169.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Бельгия.png"))); // NOI18N
        jLabel169.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel172.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Алжир.png"))); // NOI18N
        jLabel172.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel173.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Ю.Корея.png"))); // NOI18N
        jLabel173.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel176.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Россия.png"))); // NOI18N
        jLabel176.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel177.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Бельгия.png"))); // NOI18N
        jLabel177.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel180.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Россия.png"))); // NOI18N
        jLabel180.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel181.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Ю.Корея.png"))); // NOI18N
        jLabel181.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel184.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Алжир.png"))); // NOI18N
        jLabel184.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel185.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Алжир.png"))); // NOI18N
        jLabel185.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel188.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Россия.png"))); // NOI18N
        jLabel188.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel189.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Ю.Корея.png"))); // NOI18N
        jLabel189.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel192.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wc2014/resources/Бельгия.png"))); // NOI18N
        jLabel192.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Выберите матч");
        jLabel30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jList8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jList8.setModel(listInfoModel[7]);
        jList8.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList8.setPreferredSize(new java.awt.Dimension(166, 250));
        jScrollPane16.setViewportView(jList8);

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Результат (H:A)");
        jLabel31.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextField8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextField8.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButton8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton8.setText("Добавить");
        jButton8.addActionListener(this);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel185, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel181, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel176, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel169, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel16Layout.createSequentialGroup()
                                .addComponent(jLabel177, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel189, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(5, 5, 5)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel173, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel172, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton8, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel184, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel180, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel192, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel188, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel169)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel176)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel177)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel181)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel189)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel185))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jLabel172)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel173)))
                        .addGap(20, 20, 20)
                        .addComponent(jLabel180)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel184)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel192)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel188))
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane8)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Группа H", jPanel8);

        jPanel17.setBackground(new java.awt.Color(204, 255, 204));
        jPanel17.setPreferredSize(new java.awt.Dimension(532, 478));

        jTabbedPane2.setBackground(new java.awt.Color(204, 255, 204));

        jPanel18.setBackground(new java.awt.Color(255, 255, 204));

        jScrollPane17.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jList9.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jList9.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList9.setVisibleRowCount(7);
        jList9.setModel(playOffListInfoModel[0]);
        jScrollPane17.setViewportView(jList9);

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Выберите матч");
        jLabel34.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Результат (H:A)");
        jLabel35.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextField9.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextField9.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButton9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton9.setText("Добавить");
        jButton9.addActionListener(this);

        jLabelPlayOff1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelPlayOff2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelPlayOff3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelPlayOff4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelPlayOff5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelPlayOff6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelPlayOff7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelPlayOff8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelPlayOff9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelPlayOff10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelPlayOff11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelPlayOff12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelPlayOff13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelPlayOff14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelPlayOff15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelPlayOff16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel18Layout.createSequentialGroup()
                                            .addGap(50, 50, 50)
                                            .addComponent(jLabelPlayOff1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addComponent(jLabelPlayOff3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabelPlayOff5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabelPlayOff7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelPlayOff9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabelPlayOff11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelPlayOff15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPlayOff13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                    .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(5, 5, 5)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPlayOff2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPlayOff4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPlayOff6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPlayOff8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPlayOff10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPlayOff14, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPlayOff16, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPlayOff12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton9)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabelPlayOff1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jLabelPlayOff3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jLabelPlayOff5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jLabelPlayOff7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jLabelPlayOff9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jLabelPlayOff11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jLabelPlayOff13, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jLabelPlayOff15, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabelPlayOff2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jLabelPlayOff4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                                .addComponent(jLabelPlayOff6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44))
                            .addComponent(jLabelPlayOff8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addComponent(jLabelPlayOff10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jLabelPlayOff12, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jLabelPlayOff14, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jLabelPlayOff16, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );

        jTabbedPane2.addTab("1/8 финала", jPanel18);

        jPanel19.setBackground(new java.awt.Color(255, 255, 204));

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("Выберите матч");
        jLabel38.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelPlayOff17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jScrollPane19.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jList10.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jList10.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList10.setModel(playOffListInfoModel[1]);
        jScrollPane19.setViewportView(jList10);

        jLabelPlayOff18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("Результат (H:A)");
        jLabel43.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextField10.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextField10.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButton10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton10.setText("Добавить");
        jButton10.addActionListener(this);

        jLabelPlayOff19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelPlayOff20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelPlayOff21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelPlayOff22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelPlayOff23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelPlayOff24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabelPlayOff17, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelPlayOff19, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jLabelPlayOff21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelPlayOff23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                    .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(5, 5, 5)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPlayOff18, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPlayOff20, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPlayOff22, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPlayOff24, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton10)
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabelPlayOff17, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jLabelPlayOff19, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabelPlayOff21, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jLabelPlayOff23, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabelPlayOff18, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jLabelPlayOff20, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                                .addComponent(jLabelPlayOff22, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44))
                            .addComponent(jLabelPlayOff24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(217, 217, 217))
        );

        jTabbedPane2.addTab("1/4 финала", jPanel19);

        jPanel20.setBackground(new java.awt.Color(255, 255, 204));

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("Выберите матч");
        jLabel39.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelPlayOff25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jScrollPane21.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jList11.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jList11.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList11.setModel(playOffListInfoModel[2]);
        jScrollPane21.setViewportView(jList11);

        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel50.setText("Результат (H:A)");
        jLabel50.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextField11.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextField11.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButton11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton11.setText("Добавить");
        jButton11.addActionListener(this);

        jLabelPlayOff26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelPlayOff27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelPlayOff28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabelPlayOff25, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelPlayOff27, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                    .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(5, 5, 5)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPlayOff26, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPlayOff28, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton11)
                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabelPlayOff25, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabelPlayOff27, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabelPlayOff26, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabelPlayOff28, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(309, 309, 309))
        );

        jTabbedPane2.addTab("1/2 финала", jPanel20);

        jPanel23.setBackground(new java.awt.Color(255, 255, 204));

        jLabel70.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel70.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel70.setText("Выберите матч");
        jLabel70.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelPlayOff31.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jScrollPane30.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jList14.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jList14.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList14.setModel(playOffListInfoModel[4]);
        jScrollPane30.setViewportView(jList14);

        jLabelPlayOff32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel71.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel71.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel71.setText("Результат (H:A)");
        jLabel71.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextField13.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextField13.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButton13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton13.setText("Добавить");
        jButton13.addActionListener(this);

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabelPlayOff31, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel70, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane30, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jLabelPlayOff32, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton13)
                            .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(41, 41, 41))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPlayOff31, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPlayOff32, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane30, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(187, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Матч за 3-е место", jPanel23);

        jPanel21.setBackground(new java.awt.Color(255, 255, 204));

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("Выберите матч");
        jLabel42.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText("Результат (H:A)");
        jLabel51.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelPlayOff29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jScrollPane22.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jList12.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jList12.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList12.setModel(playOffListInfoModel[3]);
        jScrollPane22.setViewportView(jList12);

        jLabelPlayOff30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextField12.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextField12.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButton12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton12.setText("Добавить");
        jButton12.addActionListener(this);

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setText("Победитель:");
        jLabel47.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(229, 229, 229))
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabelPlayOff29, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addComponent(jLabelPlayOff30, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton12)
                                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPlayOff29, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPlayOff30, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Финал", jPanel21);

        jPanel22.setBackground(new java.awt.Color(255, 255, 204));

        jLabel54.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel54.setText(" Лучшая атака: ");
        jLabel54.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jScrollPane18.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane18.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane18.setViewportView(jTextArea1);

        jLabelStat1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelStat2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelStat3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel55.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel55.setText(" Лучшая защита: ");
        jLabel55.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jScrollPane20.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane20.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextArea2.setRows(5);
        jScrollPane20.setViewportView(jTextArea2);

        jLabelStat4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelStat5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelStat6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel58.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel58.setText(" Победы: ");
        jLabel58.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jScrollPane23.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane23.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea3.setEditable(false);
        jTextArea3.setColumns(20);
        jTextArea3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextArea3.setRows(5);
        jScrollPane23.setViewportView(jTextArea3);

        jLabelStat7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelStat8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelStat9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel59.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel59.setText(" Ничьи: ");
        jLabel59.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelStat10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jScrollPane24.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane24.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea4.setEditable(false);
        jTextArea4.setColumns(20);
        jTextArea4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextArea4.setRows(5);
        jScrollPane24.setViewportView(jTextArea4);

        jLabelStat11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelStat12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel62.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel62.setText(" Поражения: ");
        jLabel62.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelStat13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jScrollPane25.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane25.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea5.setEditable(false);
        jTextArea5.setColumns(20);
        jTextArea5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextArea5.setRows(5);
        jScrollPane25.setViewportView(jTextArea5);

        jLabelStat14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelStat15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel66.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel66.setText(" Худшая атака: ");
        jLabel66.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelStat16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jScrollPane28.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane28.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea7.setEditable(false);
        jTextArea7.setColumns(20);
        jTextArea7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextArea7.setRows(5);
        jScrollPane28.setViewportView(jTextArea7);

        jLabelStat17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelStat18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel67.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel67.setText(" Худшая защита: ");
        jLabel67.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelStat19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelStat20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jScrollPane29.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane29.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea8.setEditable(false);
        jTextArea8.setColumns(20);
        jTextArea8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextArea8.setRows(5);
        jScrollPane29.setViewportView(jTextArea8);

        jLabelStat21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(jLabel54)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel55)
                .addGap(62, 62, 62))
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jLabel66)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel67)
                .addGap(61, 61, 61))
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelStat3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelStat2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelStat1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelStat4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelStat5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelStat6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelStat7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelStat8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelStat9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelStat13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelStat14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabelStat15, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane25, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(jLabel58)
                                .addGap(105, 105, 105)
                                .addComponent(jLabel62)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabelStat10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelStat11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabelStat12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel59)
                                .addGap(37, 37, 37))))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelStat18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelStat17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelStat16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane28, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelStat19, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelStat20, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelStat21, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane29, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel54)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabelStat1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(jLabelStat2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(jLabelStat3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel55)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabelStat4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(jLabelStat5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(jLabelStat6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane20))))
                .addGap(10, 10, 10)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel66)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane28, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabelStat16, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(jLabelStat17, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(jLabelStat18, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel67)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabelStat19, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(jLabelStat20, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(jLabelStat21, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane29))))
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel58)
                            .addComponent(jLabel62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel59))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabelStat7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(jLabelStat8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(jLabelStat9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabelStat13, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(jLabelStat14, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(jLabelStat15, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane23, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                            .addComponent(jScrollPane25)
                            .addComponent(jScrollPane24)))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelStat10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(jLabelStat11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(jLabelStat12, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)))
                .addGap(10, 10, 10))
        );

        jTabbedPane2.addTab("Статистика", jPanel22);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 572, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 469, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );

        jTabbedPane1.addTab("Плей-офф", jPanel17);

        jPanel24.setBackground(new java.awt.Color(255, 255, 204));

        jLabel63.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel63.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel63.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jList13.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jList13.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Австралия", "Алжир", "Англия", "Аргентина", "Бельгия", "Босния", "Бразилия", "Гана", "Германия", "Гондурас", "Греция", "Иран", "Испания", "Италия", "Камерун", "Колумбия", "Коста-Рика", "Кот-д'Ивуар", "Мексика", "Нигерия", "Нидерланды", "Португалия", "Россия", "США", "Уругвай", "Франция", "Хорватия", "Чили", "Швейцария", "Эквадор", "Ю.Корея", "Япония" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList13.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList13.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList13ValueChanged(evt);
            }
        });
        jScrollPane26.setViewportView(jList13);

        jTextArea6.setEditable(false);
        jTextArea6.setColumns(20);
        jTextArea6.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTextArea6.setRows(5);
        jScrollPane27.setViewportView(jTextArea6);

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane26, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel63, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                    .addComponent(jScrollPane27))
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane26)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(jScrollPane27, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );

        jTabbedPane1.addTab("Информация", jPanel24);

        jMenu1.setText("Файл");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Сохранить");
        jMenuItem1.addActionListener(this);
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem2.setText("Выход");
        jMenuItem2.addActionListener(this);
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Справка");

        jMenuItem3.setText("О программе");
        jMenuItem3.addActionListener(this);
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        processMatchResult(groups[0], tableInfoModel[0], listInfoModel[0], jList1, jTextField1.getText().trim(), "A");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jList13ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList13ValueChanged
        setInfo();
    }//GEN-LAST:event_jList13ValueChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WorldCup2014.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WorldCup2014.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WorldCup2014.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WorldCup2014.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WorldCup2014().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel165;
    private javax.swing.JLabel jLabel168;
    private javax.swing.JLabel jLabel169;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel172;
    private javax.swing.JLabel jLabel173;
    private javax.swing.JLabel jLabel176;
    private javax.swing.JLabel jLabel177;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel180;
    private javax.swing.JLabel jLabel181;
    private javax.swing.JLabel jLabel184;
    private javax.swing.JLabel jLabel185;
    private javax.swing.JLabel jLabel188;
    private javax.swing.JLabel jLabel189;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel192;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabelPlayOff1;
    private javax.swing.JLabel jLabelPlayOff10;
    private javax.swing.JLabel jLabelPlayOff11;
    private javax.swing.JLabel jLabelPlayOff12;
    private javax.swing.JLabel jLabelPlayOff13;
    private javax.swing.JLabel jLabelPlayOff14;
    private javax.swing.JLabel jLabelPlayOff15;
    private javax.swing.JLabel jLabelPlayOff16;
    private javax.swing.JLabel jLabelPlayOff17;
    private javax.swing.JLabel jLabelPlayOff18;
    private javax.swing.JLabel jLabelPlayOff19;
    private javax.swing.JLabel jLabelPlayOff2;
    private javax.swing.JLabel jLabelPlayOff20;
    private javax.swing.JLabel jLabelPlayOff21;
    private javax.swing.JLabel jLabelPlayOff22;
    private javax.swing.JLabel jLabelPlayOff23;
    private javax.swing.JLabel jLabelPlayOff24;
    private javax.swing.JLabel jLabelPlayOff25;
    private javax.swing.JLabel jLabelPlayOff26;
    private javax.swing.JLabel jLabelPlayOff27;
    private javax.swing.JLabel jLabelPlayOff28;
    private javax.swing.JLabel jLabelPlayOff29;
    private javax.swing.JLabel jLabelPlayOff3;
    private javax.swing.JLabel jLabelPlayOff30;
    private javax.swing.JLabel jLabelPlayOff31;
    private javax.swing.JLabel jLabelPlayOff32;
    private javax.swing.JLabel jLabelPlayOff4;
    private javax.swing.JLabel jLabelPlayOff5;
    private javax.swing.JLabel jLabelPlayOff6;
    private javax.swing.JLabel jLabelPlayOff7;
    private javax.swing.JLabel jLabelPlayOff8;
    private javax.swing.JLabel jLabelPlayOff9;
    private javax.swing.JLabel jLabelStat1;
    private javax.swing.JLabel jLabelStat10;
    private javax.swing.JLabel jLabelStat11;
    private javax.swing.JLabel jLabelStat12;
    private javax.swing.JLabel jLabelStat13;
    private javax.swing.JLabel jLabelStat14;
    private javax.swing.JLabel jLabelStat15;
    private javax.swing.JLabel jLabelStat16;
    private javax.swing.JLabel jLabelStat17;
    private javax.swing.JLabel jLabelStat18;
    private javax.swing.JLabel jLabelStat19;
    private javax.swing.JLabel jLabelStat2;
    private javax.swing.JLabel jLabelStat20;
    private javax.swing.JLabel jLabelStat21;
    private javax.swing.JLabel jLabelStat3;
    private javax.swing.JLabel jLabelStat4;
    private javax.swing.JLabel jLabelStat5;
    private javax.swing.JLabel jLabelStat6;
    private javax.swing.JLabel jLabelStat7;
    private javax.swing.JLabel jLabelStat8;
    private javax.swing.JLabel jLabelStat9;
    private javax.swing.JList jList1;
    private javax.swing.JList jList10;
    private javax.swing.JList jList11;
    private javax.swing.JList jList12;
    private javax.swing.JList jList13;
    private javax.swing.JList jList14;
    private javax.swing.JList jList2;
    private javax.swing.JList jList3;
    private javax.swing.JList jList4;
    private javax.swing.JList jList5;
    private javax.swing.JList jList6;
    private javax.swing.JList jList7;
    private javax.swing.JList jList8;
    private javax.swing.JList jList9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane27;
    private javax.swing.JScrollPane jScrollPane28;
    private javax.swing.JScrollPane jScrollPane29;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane30;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    private javax.swing.JTable jTable8;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JTextArea jTextArea6;
    private javax.swing.JTextArea jTextArea7;
    private javax.swing.JTextArea jTextArea8;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
