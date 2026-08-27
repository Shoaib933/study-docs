"use client";

import React from "react";
import { motion } from "framer-motion";
import { ClipboardCheck, Target, Briefcase, Zap } from "lucide-react";
import { Card, CardContent } from "@/components/ui/card";

interface VerdictCardProps {
    roleFitLevel: string;
    finalVerdict: string;
    careerReadiness: string;
}

export function VerdictCard({ roleFitLevel, finalVerdict, careerReadiness }: VerdictCardProps) {
    const getVerdictStyle = () => {
        switch (roleFitLevel?.trim()) {
            case "Excellent":
                return {
                    border: "border-green-500/20",
                    text: "text-green-600 dark:text-green-500",
                    bg: "bg-green-500/10",
                };
            case "Good":
                return {
                    border: "border-blue-500/20",
                    text: "text-blue-600 dark:text-blue-500",
                    bg: "bg-blue-500/10",
                };
            case "Poor":
                return {
                    border: "border-red-500/20",
                    text: "text-red-600 dark:text-red-500",
                    bg: "bg-red-500/10",
                };
            case "Average":
            default:
                return {
                    border: "border-yellow-500/20",
                    text: "text-yellow-600 dark:text-yellow-500",
                    bg: "bg-yellow-500/10",
                };
        }
    };

    const style = getVerdictStyle();

    return (
        <motion.div
            initial={{ opacity: 0, scale: 0.95 }}
            whileInView={{ opacity: 1, scale: 1 }}
            viewport={{ once: true }}
            transition={{ duration: 0.5 }}
        >
            <Card className={`glass-card overflow-hidden relative ${style.border} mt-8`}>
                <CardContent className="p-8 md:p-12 relative z-10 flex flex-col items-center text-center">

                    <div className={`inline-flex items-center justify-center p-4 mb-6 rounded-2xl ${style.bg} border-none`}>
                        <ClipboardCheck className={`w-8 h-8 ${style.text}`} />
                    </div>

                    <h2 className="text-3xl font-bold tracking-tight mb-4 text-foreground">
                        Analysis Verdict
                    </h2>

                    <div className="inline-block relative mb-8">
                        <h3 className={`text-4xl md:text-5xl font-black uppercase tracking-widest relative z-10 ${style.text}`}>
                            {roleFitLevel}
                        </h3>
                    </div>

                    <p className="text-xl md:text-2xl text-muted-foreground max-w-3xl leading-relaxed mb-10 font-medium">
                        "{finalVerdict}"
                    </p>

                    <div className="grid grid-cols-1 md:grid-cols-2 gap-4 w-full max-w-2xl">
                        <div className="flex items-center gap-3 bg-secondary/50 rounded-xl p-4 border border-white/5">
                            <div className={`p-2 rounded-lg ${style.bg}`}>
                                <Target className={`w-5 h-5 ${style.text}`} />
                            </div>
                            <div className="text-left">
                                <p className="text-sm text-muted-foreground uppercase tracking-wider font-semibold">Role Fit</p>
                                <p className="font-medium">{roleFitLevel} Candidate</p>
                            </div>
                        </div>

                        <div className="flex items-center gap-3 bg-secondary/50 rounded-xl p-4 border border-white/5">
                            <div className="p-2 rounded-lg bg-primary/10">
                                <Zap className="w-5 h-5 text-primary" />
                            </div>
                            <div className="text-left">
                                <p className="text-sm text-muted-foreground uppercase tracking-wider font-semibold">Career Readiness</p>
                                <p className="font-medium">{careerReadiness}</p>
                            </div>
                        </div>
                    </div>

                </CardContent>
            </Card>
        </motion.div>
    );
}
