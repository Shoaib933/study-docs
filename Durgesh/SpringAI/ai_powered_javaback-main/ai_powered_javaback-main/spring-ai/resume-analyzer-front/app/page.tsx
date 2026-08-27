"use client";

import { useState } from "react";
import { motion, AnimatePresence } from "framer-motion";

import { ResumeUploadSection } from "@/components/upload/resume-upload-section";
import { ModeToggle } from "@/components/mode-toggle";
import Link from "next/link";
import { ScoreOverview } from "@/components/dashboard/score-overview";
import { AnalysisCharts } from "@/components/dashboard/analysis-charts";
import { StrengthsAndImprovements } from "@/components/dashboard/strengths-improvements";
import { SkillsAnalysis } from "@/components/dashboard/skills-analysis";
import { ExperienceGapAnalysis } from "@/components/dashboard/experience-gap";
import { VerdictCard } from "@/components/dashboard/verdict-card";
import { ResumeOptimizationSection } from "@/components/dashboard/resume-optimization";
import { LearningRoadmap } from "@/components/dashboard/learning-roadmap";
import { ResumePreview } from "@/components/dashboard/resume-preview";

export default function Home() {
  const [isAnalyzing, setIsAnalyzing] = useState(false);
  const [analysisResult, setAnalysisResult] = useState<any>(null);

  const handleAnalyze = async (file: File, jobProfile: string) => {
    setIsAnalyzing(true);

    try {
      const formData = new FormData();
      formData.append("resume", file);
      formData.append("jobProfile", jobProfile);

      const response = await fetch("http://localhost:8081/api/v1/resume", {
        method: "POST",
        body: formData,
      });

      if (!response.ok) {
        throw new Error("Failed to analyze resume");
      }

      const rawData = await response.json();
      console.log(rawData);

      const mappedResult = {
        scores: {
          technicalScore: rawData.technicalScore || 0,
          communicationScore: rawData.communicationScore || 0,
          domainScore: rawData.domainScore || 0,
          experienceScore: rawData.experienceScore || 0,
          atsScore: rawData.atsScore || 0,
          matchPercentage: rawData.matchingPercentage || 0,
        },
        chartData: {
          radarData: [
            { subject: 'Technical', score: rawData.technicalScore || 0 },
            { subject: 'Communication', score: rawData.communicationScore || 0 },
            { subject: 'Domain', score: rawData.domainScore || 0 },
            { subject: 'Experience', score: rawData.experienceScore || 0 },
            { subject: 'ATS Ready', score: rawData.atsScore || 0 },
          ],
          barData: [
            { name: 'Core Fit', strengths: rawData.strengths?.length || 0, improvements: rawData.improvements?.length || 0 },
            { name: 'Keywords', strengths: 5, improvements: rawData.keywordGaps?.length || 0 },
            { name: 'ATS Risks', strengths: 5, improvements: rawData.atsRisks?.length || 0 },
            { name: 'Optimization', strengths: 4, improvements: rawData.resumeOptimizationTips?.length || 0 },
          ]
        },
        insights: {
          strengths: rawData.strengths || [],
          improvements: rawData.improvements || []
        },
        skills: {
          missingSkills: rawData.missingSkills || [],
          keywordGaps: rawData.keywordGaps || [],
          recommendedTech: rawData.recommendedTechnologies || [],
          recommendedCerts: rawData.recommendedCertifications || []
        },
        experience: {
          required: rawData.experienceGapAnalysis?.requiredYears || 0,
          actual: rawData.experienceGapAnalysis?.actualYears || 0,
          gapSummary: rawData.experienceGapAnalysis?.gapSummary || ""
        },
        verdict: {
          roleFitLevel: rawData.roleFitLevel || "Average",
          text: rawData.finalRecruiterVerdict || "",
          readiness: rawData.careerReadinessLevel || ""
        },
        optimization: {
          atsRisks: rawData.atsRisks || [],
          tips: rawData.resumeOptimizationTips || [],
          highImpactFixes: rawData.highImpactResumeFixes || []
        },
        roadmap: {
          shortTermText: rawData.shortTermLearningGoals || [],
          longTermText: rawData.longTermLearningGoals || []
        },
        markdown: rawData.improvedResumeMarkdown || "No markdown returned."
      };

      setAnalysisResult(mappedResult);
      window.scrollTo({ top: 0, behavior: "smooth" });
    } catch (error) {
      console.error("Error analyzing resume:", error);
      alert("Error parsing resume from AI. Please make sure the backend server (localhost:8081) is running.");
    } finally {
      setIsAnalyzing(false);
    }
  };

  const resetAnalysis = () => {
    setAnalysisResult(null);
    window.scrollTo({ top: 0, behavior: "smooth" });
  };

  return (
    <main className="min-h-screen relative overflow-hidden bg-background">
      <div className="container mx-auto px-4 py-8 relative z-10">
        {/* Header / Nav Area (Simple) */}
        {!analysisResult && (
          <header className="flex justify-between items-center mb-12">
            <div className="flex items-center gap-2">
              <span className="font-bold text-xl tracking-tight">ResumeAnalyzer<span className="text-primary">.pro</span></span>
            </div>
            <nav className="hidden md:flex items-center gap-6 text-sm font-medium text-muted-foreground">
              <Link href="/features" className="hover:text-foreground transition-colors">Features</Link>
              <a href="#" className="hover:text-foreground transition-colors">Pricing</a>
              <a href="#" className="hover:text-foreground transition-colors">Enterprise</a>
              <ModeToggle />
            </nav>
          </header>
        )}

        <AnimatePresence mode="wait">
          {!analysisResult ? (
            <motion.div
              key="upload-view"
              initial={{ opacity: 0 }}
              animate={{ opacity: 1 }}
              exit={{ opacity: 0, y: -20, filter: "blur(10px)" }}
              transition={{ duration: 0.5 }}
              className="flex items-center justify-center min-h-[70vh]"
            >
              <ResumeUploadSection onAnalyze={handleAnalyze} isLoading={isAnalyzing} />
            </motion.div>
          ) : (
            <motion.div
              key="dashboard-view"
              initial={{ opacity: 0, y: 40 }}
              animate={{ opacity: 1, y: 0 }}
              transition={{ duration: 0.8, staggerChildren: 0.1 }}
              className="space-y-12 pb-24"
            >
              <div className="flex items-center justify-between sticky top-0 z-50 bg-background/80 backdrop-blur-xl border-b border-white/5 py-4 pb-4 -mx-4 px-4 sm:mx-0 sm:px-0">
                <div>
                  <h1 className="text-3xl font-bold tracking-tight">Analysis Complete</h1>
                  <p className="text-muted-foreground text-sm flex items-center gap-2">
                    <span className="w-2 h-2 rounded-full bg-green-500 animate-pulse"></span>
                    Live AI insights generated
                  </p>
                </div>
                <button
                  onClick={resetAnalysis}
                  className="px-4 py-2 rounded-lg text-sm font-medium bg-white/5 border border-white/10 hover:bg-white/10 transition-colors"
                >
                  Analyze New Resume
                </button>
              </div>

              <motion.div className="space-y-6">
                <VerdictCard
                  roleFitLevel={analysisResult.verdict.roleFitLevel}
                  finalVerdict={analysisResult.verdict.text}
                  careerReadiness={analysisResult.verdict.readiness}
                />
              </motion.div>

              <motion.div className="space-y-6 pt-4 border-t border-white/5">
                <ScoreOverview data={analysisResult.scores} />
              </motion.div>

              <motion.div className="space-y-6 pt-4 border-t border-white/5">
                <AnalysisCharts
                  radarData={analysisResult.chartData.radarData}
                  barData={analysisResult.chartData.barData}
                />
              </motion.div>

              <motion.div className="space-y-6 pt-4 border-t border-white/5">
                <h3 className="text-2xl font-bold mb-4 tracking-tight">Deep Dive Insights</h3>
                <StrengthsAndImprovements
                  strengths={analysisResult.insights.strengths}
                  improvements={analysisResult.insights.improvements}
                />
              </motion.div>

              <motion.div className="grid grid-cols-1 xl:grid-cols-2 gap-6 pt-4 border-t border-white/5">
                <div className="h-full">
                  <SkillsAnalysis
                    missingSkills={analysisResult.skills.missingSkills}
                    keywordGaps={analysisResult.skills.keywordGaps}
                    recommendedTech={analysisResult.skills.recommendedTech}
                    recommendedCerts={analysisResult.skills.recommendedCerts}
                  />
                </div>
                <div className="h-full">
                  <ExperienceGapAnalysis
                    requiredExperience={analysisResult.experience.required}
                    actualExperience={analysisResult.experience.actual}
                    gapSummary={analysisResult.experience.gapSummary}
                  />
                </div>
              </motion.div>

              <motion.div className="grid grid-cols-1 xl:grid-cols-2 gap-6 pt-4 border-t border-white/5">
                <div>
                  <h3 className="text-2xl font-bold mb-4 tracking-tight">Strategy Guide</h3>
                  <ResumeOptimizationSection
                    atsRisks={analysisResult.optimization.atsRisks}
                    optimizationTips={analysisResult.optimization.tips}
                    highImpactFixes={analysisResult.optimization.highImpactFixes}
                  />
                </div>
                <div>
                  <h3 className="text-2xl font-bold mb-4 tracking-tight opacity-0 select-none hidden xl:block">Strategy Guide Spacer</h3>
                  <LearningRoadmap
                    shortTermGoals={analysisResult.roadmap.shortTermText}
                    longTermGoals={analysisResult.roadmap.longTermText}
                  />
                </div>
              </motion.div>

              <motion.div className="space-y-6 pt-4 border-t border-white/5">
                <div className="max-w-4xl mx-auto">
                  <ResumePreview markdown={analysisResult.markdown} />
                </div>
              </motion.div>

            </motion.div>
          )}
        </AnimatePresence>

      </div>
    </main>
  );
}
