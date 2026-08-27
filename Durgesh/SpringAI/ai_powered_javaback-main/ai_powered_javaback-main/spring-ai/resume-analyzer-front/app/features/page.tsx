"use client";

import { motion } from "framer-motion";
import Link from "next/link";
import { ModeToggle } from "@/components/mode-toggle";
import {
    Bot,
    LineChart,
    Target,
    Zap,
    FileCheck,
    Compass,
    ArrowRight
} from "lucide-react";

const features = [
    {
        title: "AI Recruiter Verdict",
        description: "Get an instant, honest assessment of your profile just like a real hiring manager would provide, complete with a role-fit level.",
        icon: <Bot className="w-6 h-6 text-primary" />,
    },
    {
        title: "Comprehensive Scoring",
        description: "We evaluate your resume across 5 key dimensions: Technical Skills, Communication, Domain Knowledge, Experience, and ATS Readiness.",
        icon: <LineChart className="w-6 h-6 text-blue-500" />,
    },
    {
        title: "Keyword Gap Analysis",
        description: "Discover exactly which industry keywords your resume is missing compared to your target job profile.",
        icon: <Target className="w-6 h-6 text-red-500" />,
    },
    {
        title: "High-Impact Fixes",
        description: "Actionable, prioritized advice on how to improve your resume right now to increase your callback rate.",
        icon: <Zap className="w-6 h-6 text-yellow-500" />,
    },
    {
        title: "ATS Optimization",
        description: "Identify formatting risks and hidden issues that might cause your resume to be automatically rejected by Applicant Tracking Systems.",
        icon: <FileCheck className="w-6 h-6 text-green-500" />,
    },
    {
        title: "Custom Learning Roadmap",
        description: "Based on your skill gaps, receive a personalized short-term and long-term learning plan to land your dream role.",
        icon: <Compass className="w-6 h-6 text-purple-500" />,
    },
];

export default function FeaturesPage() {
    return (
        <main className="min-h-screen relative overflow-hidden bg-background">
            <div className="container mx-auto px-4 py-8 relative z-10 max-w-6xl">
                {/* Header */}
                <header className="flex justify-between items-center mb-16">
                    <div className="flex items-center gap-2">
                        <Link href="/" className="font-bold text-xl tracking-tight">
                            ResumeAnalyzer<span className="text-primary">.pro</span>
                        </Link>
                    </div>
                    <nav className="hidden md:flex items-center gap-6 text-sm font-medium text-muted-foreground">
                        <Link href="/" className="hover:text-foreground transition-colors">Analyzer</Link>
                        <Link href="/features" className="text-foreground transition-colors">Features</Link>
                        <a href="#" className="hover:text-foreground transition-colors">Pricing</a>
                        <ModeToggle />
                    </nav>
                </header>

                {/* Hero Section */}
                <motion.div
                    initial={{ opacity: 0, y: 20 }}
                    animate={{ opacity: 1, y: 0 }}
                    transition={{ duration: 0.5 }}
                    className="text-center mb-16 md:mb-24"
                >
                    <h1 className="text-4xl md:text-6xl font-bold tracking-tight mb-6 text-foreground">
                        Everything you need to <br className="hidden md:block" />
                        <span className="text-primary">land the interview.</span>
                    </h1>
                    <p className="text-xl text-muted-foreground max-w-2xl mx-auto">
                        Our AI doesn't just score your resume. It acts as an expert recruiter, providing deep insights, identifying critical gaps, and mapping your learning journey.
                    </p>
                </motion.div>

                {/* Features Grid */}
                <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-8 mb-24">
                    {features.map((feature, index) => (
                        <motion.div
                            key={index}
                            initial={{ opacity: 0, y: 20 }}
                            whileInView={{ opacity: 1, y: 0 }}
                            viewport={{ once: true }}
                            transition={{ duration: 0.5, delay: index * 0.1 }}
                            className="bg-card border border-border rounded-xl p-8 hover:shadow-md transition-all duration-300"
                        >
                            <div className="bg-primary/5 w-12 h-12 rounded-lg flex items-center justify-center mb-6">
                                {feature.icon}
                            </div>
                            <h3 className="text-xl font-bold mb-3">{feature.title}</h3>
                            <p className="text-muted-foreground leading-relaxed">
                                {feature.description}
                            </p>
                        </motion.div>
                    ))}
                </div>

                {/* CTA Section */}
                <motion.div
                    initial={{ opacity: 0, scale: 0.95 }}
                    whileInView={{ opacity: 1, scale: 1 }}
                    viewport={{ once: true }}
                    className="bg-primary/5 border border-primary/20 rounded-2xl p-8 md:p-12 text-center"
                >
                    <h2 className="text-3xl md:text-4xl font-bold mb-4">Ready to optimize your resume?</h2>
                    <p className="text-lg text-muted-foreground mb-8 max-w-xl mx-auto">
                        Stop guessing what recruiters want. Let our AI analyze your profile and give you the feedback you need to succeed.
                    </p>
                    <Link
                        href="/"
                        className="inline-flex items-center justify-center px-8 py-4 text-primary-foreground bg-primary hover:bg-primary/90 rounded-lg font-medium transition-colors gap-2"
                    >
                        Try Analyzer Now
                        <ArrowRight className="w-5 h-5" />
                    </Link>
                </motion.div>

            </div>
        </main>
    );
}
